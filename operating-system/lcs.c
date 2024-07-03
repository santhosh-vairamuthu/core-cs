#include<stdio.h>
#include<string.h>
#define MAX 1000

int main(){
    char s1[MAX],s2[MAX];
    printf("Enter String one : ");
    scanf("%s",s1);
    printf("Enter String two : ");
    scanf("%s",s2);
    int l1=strlen(s1),l2=strlen(s2);
    int table[l1+1][l2+1];
    for(int x=0;x<=l1;x++){
        for(int y=0;y<=l2;y++){
            if(x==0 || y==0){
                table[x][y]=00;
            }
            else if (s1[x-1] == s2[y-1]){
                table[x][y] = 1 + table[x-1][y-1];
            }else{
                int temp=0;
                if(table[x][y-1] > table[x-1][y]){
                    temp=table[x][y-1];
                }else{
                    temp=table[x-1][y];
                }
                table[x][y]=temp;
            }
            printf("%d ",table[x][y]);
        }
        printf("\n");
    }
    printf("\nThe Length of Longest Common Sequence is %d\n",table[l1][l2]);

}