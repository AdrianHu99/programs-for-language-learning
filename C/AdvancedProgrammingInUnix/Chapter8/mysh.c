#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>


#define DELIMS " \t\n"

static void promt(void) {
    printf("mysh-0.1$ ");
}

static void parse(char *line) {
    char *tok;
    glob_t globres;
    while (1)
    {
        tok = strsep(&line, DELIMS);
        if (tok == NULL) {
            break;
        }
        if (tok[0] == '\0') {
            continue;
        }

        glob(tok, GLOB_NOCHECK|GLOB_APPEND, NULL, &globres);
    }
    
}

int main()
{

    char *linebuf = NULL;
    size_t linebuf_size = 0;

    pid_t pid;
    while(1) {
        prompt();

        // get everything until \n
        if(getline(&linebuf, linebuf_size, stdin)<0)
            break;

        // make sure it's internal command or external command
        parse(linebuf);

        if (1) { // external command - as long as the byte executable file is stored in disk
            pid = fork();
            if (pid < 0) {

            }
        }
    }










    exit(0);
}