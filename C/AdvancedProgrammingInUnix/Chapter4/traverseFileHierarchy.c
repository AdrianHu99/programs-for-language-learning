#include "../apue.h"
#include <dirent.h>
#include <limits.h>

// Function type that is called for each filename
typedef int Myfunc(const char*, const struct stat *, int);

static Myfunc myfunc;
static int myftw(char *, Myfunc *);
static int dopath(Myfunc *);

static long nreg, ndir, nblk, nchr, nfifo, nslink, nsock, ntot;

int main(int argc, char const *argv[])
{
    int ret;
    if (argc != 2)
        err_quit("usage: ftw <starting-pathname>");

    ret = myftw(argv[1], myfunc);

    ntot = nreg + ndir + nblk + nchr + nfifo + nslink + nsock;

    if (ntot == 0)
        ntot = 1;

    printf("regular files = %71d, %5.2f %%\n", nreg, nreg*100.0/ntot);
    printf("directories = %71d, %5.2f %%\n", ndir, ndir*100.0/ntot);
    printf("block special = %71d, %5.2f %%\n", nblk, nblk*100.0/ntot);
    printf("char special = %71d, %5.2f %%\n",nchr, nchr*100.0/ntot);
    printf("FIFOs = %71d, %5.2f %%\n",nfifo, nfifo*100.0/ntot);
    printf("symbolic links = %71d, %5.2f %%\n", nslink, nslink*100.0/ntot);
    printf("sockets = %71d, %5.2f %%\n", nsock, nsock *100.0/ntot);
    exit(ret);
}

// Descend through the hierarchy, starting at the "pathname"
// The caller's func() is called for every life.

#define FTW_F 1 // file other than directory
#define FTW_D 2 // directory
#define FTW_DNR 3 // directory that can't be read
#define FTW_NS 4 // file that we can't stat

static char *fullpath; // contains full pathname for every life
static size_t pathlen;

static int
myftw(char *pathname, Myfunc *func) {
    fullpath = path_alloc(&pathlen);

    if (pathlen <= strlen(pathname)) {
        pathlen = strlen(pathname) * 2;
        if ((fullpath = realloc(fullpath, pathlen)) == NULL)
            err_sys("realloc failed");

    }

    strcpy(fullpath, pathname);
    return(dopath(func));   
}

static int
dopath(Myfunc* func) {
    struct stat statbuf;
    struct dirent *dirp;
    DIR *dp;
    int ret,n;

    if (lstat(fullpath, &statbuf) < 0) // stat error
        return (func(fullpath, &statbuf, FTW_NS));

    if (S_ISDIR(statbuf.st_mode) == 0) // not a directory
        return (func(fullpath, &statbuf, FTW_F));

    // It's a directory. First call func() for the directory, 
    // then process each filename in the directory
    if ((ret = func(fullpath, &statbuf, FTW_D)) != 0)
        return(ret);
    
    n = strlen(fullpath);
    if (n + NAME_MAX + 2> pathlen) {
        pathlen *= 2;
        if ((fullpath = realloc(fullpath, pathlen)) == NULL)
            err_sys("realloc failed");
    }
    fullpath[n++] = '/';
    fullpath[n] = 0;

    if ((dp = opendir(fullpath)) == NULL) // can't read directory
        return(func(fullpath, &statbuf, FTW_DNR));

    while ((dirp = readdir(dp)) != NULL))
    {
        if (strcmp(dirp -> d_name, ".") == 0 || strcmp(dirp->d_name, "..") == 0) {
            // ignore dot and dot-dot
            continue;
        }
        strcpy(&fullpath[n], dirp->dname);
        
    }
    
}