#include <stdio.h>
#include <stdlib.h>

int main(){
    int pro, res, i, j, k;
    printf("Enter number of processes: ");
    scanf("%d",&pro);
    printf("Enter number of resources: ");
    scanf("%d",&res);
    int alloc[pro][res],max[pro][res],avail[res];
    for(int i=0;i<pro;i++){
        printf("Enter allocated resource for process %d : ",i+1);
        for(int j=0;j<res;j++){
            scanf("%d",&alloc[i][j]);
        }
    }
    for(int i=0;i<pro;i++){
        printf("Enter max allocated resource for process %d : ",i+1);
        for(int j=0;j<res;j++){
            scanf("%d",&max[i][j]);
        }
    }
    printf("\nEnter available resource :");    
    for(int i=0;i<res;i++){
        scanf("%d",&avail[i]);
    }
    int f[pro], safe[pro], ind = 0;
    for (i = 0; i < pro; i++){
        f[i] = 0;
    }
    int need[pro][res];
    for (i = 0; i < pro; i++){
        for (j = 0; j < res; j++){  
            need[i][j] = max[i][j] - alloc[i][j];
        }
    }
    int y = 0;
    for (k = 0; k < pro; k++){
        for (i = 0; i < pro; i++){
            if (f[i] == 0) {
                int flag = 0;
                for (j = 0; j < res; j++){
                    if (need[i][j] > avail[j]){
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0){
                    safe[ind++] = i;
                    for (y = 0; y < res; y++){
                        avail[y] += alloc[i][y];
                    }
                    f[i] = 1;
                }
            }
        }
    }
    int flag = 1;
    for(int i=0;i<pro;i++){
        if(f[i]==0){
            flag=0;
            printf("The following system is not safe");
            break;
        }
    }
    if(flag==1){
        printf("Following is the SAFE Sequence\n");
        for (i = 0; i < pro - 1; i++){
            printf(" P%d ->", safe[i]);
        }
        printf(" P%d\n", safe[pro - 1]);
    }
    return (0);
}

