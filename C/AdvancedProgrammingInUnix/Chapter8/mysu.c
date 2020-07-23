#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

/*
./mysu 0 cat /etc/shadow

At the beginning you will get permission issue, what you can do is: 
'sudo su' first to get root access
chown root mysu
chmod u+s mysu 
so executing mysu will need the user id of the file itself
*/
int main(int argc, char **argv)
{
    pid_t pid;
    if (argc < 3) {
        fprintf(stderr, "Usage...\n");
        exit(1);
    }

    pid = fork();
    if (pid < 0) {
        perror("fork...");
        exit(1);
    }

    if (pid == 0) {
        // use atoi to transform string to int
        setuid(atoi(argv[1]));
        execvp(argv[2], argv+2);
        perror("execvp()...");
        exit(1);
    }
    exit(0);
}
