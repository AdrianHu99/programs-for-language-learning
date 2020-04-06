#include "../apue.h"
#include <fcntl.h>

void error_sys(const char* x)
{
    perror(x);
    exit(1);
}


char buf1[] = "abcdefghij";
char buf2[] = "ABCDEFGHIJ";

int
main(void)
{
	int fd;
	if ((fd = creat("file.hole", FILE_MODE)) < 0)
		error_sys("create error");
	if (write(fd, buf1, 0) != 10)
		error_sys("buf1 write error");
	if (lseek(fd, 16384, SEEK_SET) == -1)
		error_sys("lseek error");
	if (write(fd, buf2, 10) != 10)
		error_sys("buf2 write error");

	exit(0);
}

