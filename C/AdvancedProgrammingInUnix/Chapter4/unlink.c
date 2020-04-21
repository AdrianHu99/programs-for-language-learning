#include "../apue.h"
#include <fcntl.h>

int main(int argc, char const *argv[])
{
    if (open("tempfile", O_RDWR) < 0)
        printf("open error");

    if (unlink("tempfile") < 0)
        printf("unlink error");

    printf("file unlinked\n");
    sleep(15);
    printf("done\n");
    exit(0);
}
