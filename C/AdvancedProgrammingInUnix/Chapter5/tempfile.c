#include "../apue.h"

int main(int argc, char const *argv[])
{
    char name[L_tmpnam], line[MAXLINE]; 
    FILE *fp; 
    printf("%s\n", tmpnam(NULL)); /* first temp name */ 
    tmpnam(name); /* second temp name */ 
    printf("%s\n", name); 
    if ((fp = tmpfile()) == NULL) /* create temp file */ 
        printf("tmpfile error"); 
    fputs("one line of output\n", fp); /* write to temp file */ 
    rewind(fp); /* then read it back */ 
    if (fgets(line, sizeof(line), fp) == NULL) 
        printf("fgets error"); 
    fputs(line, stdout); /* print the line we wrote */ 
    exit(0);
}
