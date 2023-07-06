#include<stdio.h>
#include<dirent.h>
int main(int argc,char *argv[])
{
    DIR *dp;
    struct dirent *dirp; 
    dp=opendir(argv[1]); 
    while((dirp=readdir(dp))!=NULL) {
    printf("%s",dirp->d_name);
    }
    closedir(dp);
}