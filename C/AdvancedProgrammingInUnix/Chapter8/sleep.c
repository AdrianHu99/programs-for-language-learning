#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main()
{

    pid_t pid;
    puts("Begin!");

    fflush(NULL);

    pid = fork();
    if (pid <0) {
        perror("fork()");
        exit(1);
    }

    if (pid == 0) {
        // we actually don't care argv[0], so if you switch "sleep" to something else, it is also working as sleep but in 'ps axf' you will see something other than sleep
        execl("/bin/sleep", "sleep", "100", NULL);
        perror("execl()");
        exit(1);
    }

    wait(NULL);

    puts("End!");

    exit(0);
}