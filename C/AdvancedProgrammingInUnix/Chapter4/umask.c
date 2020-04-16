#include "../apue.h"
#include <fcntl.h>

// user read/write, group read/write, other read/write
#define RWRWRW (S_IRUSR|S_IWUSR|S_IRGRP|S_IWGRP|S_IROTH|S_IWOTH)

int main(int argc, char const *argv[])
{
    umask(0);
    // it will create -rw-rw-rw-
    if (creat("foo", RWRWRW) < 0)
    {
        printf("create error for foo");
    }
    umask(S_IRGRP|S_IWGRP|S_IROTH|S_IWOTH);
    // it will create -rw----------
    if (creat("bar", RWRWRW) < 0)
    {
        printf("create error for bar");
    }
    exit(0);
}
