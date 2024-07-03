#include<stdio.h>
int main()
{
    int fd[2],child; 
    char a[10];
    printf("Enter the string to enter into the pipe:"); 
    scanf("%s",a);
    pipe(fd); 
    child=fork();
    if(!child)
    {
        close(fd[0]); 
        write(fd[1],a,strlen(a)); 
        wait(0);
    }
    else
    {
        close(fd[1]);
        read(fd[0],a,10);
        printf("\nThe String retrieved from the pipe is: %s\n",a);
    }
return 0;
}
