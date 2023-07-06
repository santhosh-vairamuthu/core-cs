#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void print(int p[][2],int mb[][2],int nop,int nob){
    for(int i=0;i<nop;i++){
        for(int j=0;j<nob;j++){
            if(mb[j][0] >= p[i][0] && mb[j][1]==0){
                p[i][1]=mb[j][0];
                mb[j][1]=1;
                break;
            }
        }
    }
    printf("\nPno\tPSize\tBSize\tFragment\n");
    for(int i=0;i<nop;i++){
        if(p[i][1]==0){
            printf("%d\t%d\t-\t-\n",i+1,p[i][0]);
        }else{
            printf("%d\t%d\t%d\t%d\n",i+1,p[i][0],p[i][1],p[i][1]-p[i][0]);
        }
    }
}

int asort(int p[][2],int mb[][2],int nop,int nob){
    for(int x=0;x<nob;x++){
        for(int y=x+1;y<nob;y++){
            if(mb[x][0]>mb[y][0]){
                int t=mb[x][0];
                mb[x][0]=mb[y][0];
                mb[y][0]=t;
            }
        }
    }
    print(p,mb,nop,nob);
}

int dsort(int p[][2],int mb[][2],int nop,int nob){
    for(int x=0;x<nob;x++){
        for(int y=x+1;y<nob;y++){
            if(mb[x][0]<mb[y][0]){
                int t=mb[x][0];
                mb[x][0]=mb[y][0];
                mb[y][0]=t;
            }
        }
    }
    print(p,mb,nop,nob);
}

int main(){
    int nop,nob;
    printf("Enter number of block : ");
    scanf("%d",&nob);
    int mb[nob];

    for(int i=0;i<nob;i++){
        printf("\nEnter size of block %d : ",i+1);
        scanf("%d",&mb[i]);
    }
    printf("\n\nEnter number of process : ");
    scanf("%d",&nop);
    int p[nop];

    for(int i=0;i<nop;i++){
        printf("\nEnter size of process %d : ",i+1);
        scanf("%d",&p[i]);
    }
    while(1){
        printf("\n1 - First Fit\n2 - Best Fit\n3 - WorstFit\n4 - EXIT\n");
        int ch;
        printf("\nEnter your choice : ");
        int cp[nop][2],cmb[nob][2];
        scanf("%d",&ch);
        for(int i=0;i<nop;i++){
            cp[i][0]=p[i];
            cp[i][1]=0;
        }
        for(int i=0;i<nob;i++){
            cmb[i][0]=mb[i];
            cmb[i][1]=0;
        }
        if(ch==1){
            print(cp,cmb,nop,nob); 
        }
        else if(ch==2){
            asort(cp,cmb,nop,nob);
        }else if(ch==3){
            dsort(cp,cmb,nop,nob);
        }
        else{
            break;
        }
    }
}