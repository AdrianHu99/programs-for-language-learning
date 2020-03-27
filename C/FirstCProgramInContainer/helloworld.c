#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#define random(x) (rand()%x)

void main()
{
	char buf[20]="hello world!\n";
	int h=0,m=0,s=0;
	int t=0;

	while(1)
	{
		t=time(0);
		s=t%60;
		m=t%3600/60;
		h=(t%(24*3600)/3600+8)%24;

		printf("%02d:%02d:%02d %s", h,m,s,buf);
		sleep(random(10));
	}
}
