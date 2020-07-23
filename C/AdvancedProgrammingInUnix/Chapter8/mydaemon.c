#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

#define FNAME "/tmp/out"

static int daemonize(void) {
    pid_t pid;
    int fd;
    pid = fork();
    if (pid < 0) {
        perror("fork");
        return -1;
    }

    // terminate parent process so it won't keep waiting
    if (pid > 0) {
        exit(0);
    }

    fd = open("/dev/null", O_RDWR);
    if (fd < 0) {
        perror("open()");
        return -1;
    }

    // redirect fd to standard input, output and error
    dup2(fd, 0);
    dup2(fd, 1);
    dup2(fd, 2);
    if(fd > 2) {
        close(fd);
    }

    // make it daemon process
    setsid();

    // in case it's in a directory that's busy
    chdir("/");
    // if we are sure we won't create any files
    // umask(0);
    return 0;
}



/*
ps axj to find it, and you will notice pid, pgid and sid is equal.
tail -f /tmp/out you will see it's dynamically changing
*/
int main()
{
    FILE *fp;

    if (daemonize()) {
        exit(1);
    }

    fp = fopen(FNAME, "w");

    if (fp == NULL) {
        perror("fopen()");
        exit(1);
    }

    for (int i = 0; ; i++) {
        fprintf(fp, "%d\n", i);
        // file is full cache instead of line cache, need manually flush
        fflush(fp);
        sleep(1);
    }
    return 0;
}
