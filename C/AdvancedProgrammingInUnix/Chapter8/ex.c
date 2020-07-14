#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

/*
date + %s
*/



int main() 
{
    puts("Begin!");
    // if we don't do fflush, if we output to a file, you won't see "Begin!" because it's in cache and we call execl before it flushes
    fflush(NULL);

    execl("/bin/date", "date", "+%s", NULL);
    // if execl succeeds, it won't go to below code
    perror("execl()");
    exit(1);

    puts("Ends!");

    exit(0);
}