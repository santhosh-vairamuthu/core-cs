#include<stdio.h>

int main(){
    
    int a=3;
    int* b=&a;
    printf("%d\n",*b);
    printf("%d\n",&a);
}