#include<stdio.h>
#include<stdlib.h>
#define MAX 100

int nop,count = 0,del=0;
int ready_queue[MAX][MAX],at[MAX],bt[MAX],ol=0;

void ready(){
    for(int i=0;i<nop;i++){
        for(int j=i+1;j<nop;j++){
            if(ready_queue[i][0]>ready_queue[j][0]){
                int t1=ready_queue[i][0];
                int t2=ready_queue[i][1];
                ready_queue[i][0]=ready_queue[j][0];
                ready_queue[i][1]=ready_queue[j][1];
                ready_queue[j][0]=t1;
                ready_queue[j][1]=t2;
            }else if(ready_queue[i][0]==ready_queue[j][0]){
                if(ready_queue[i][1]>ready_queue[j][1]){
                    int t2=ready_queue[i][1];
                    ready_queue[i][1]=ready_queue[j][1];
                    ready_queue[j][1]=t2;
                }
            }
        }
    }
}


int getminat(){
    del++;
    int k=ready_queue[0][1];
    at[ol]=ready_queue[0][0];
    bt[ol++]=ready_queue[0][1];
    for(int i=0;i<nop-del;i++){
        ready_queue[i][0]=ready_queue[i+1][0];
        ready_queue[i][1]=ready_queue[i+1][1];
    }
    return k;
}
int getminbt(){
    int k=ready_queue[0][1],l=0;
    for(int i=0;i<nop-del;i++){
        if (ready_queue[i][1]<k){
            k=ready_queue[i][1];
            l=i;
        }
    }
    at[ol]=ready_queue[l][0];
    bt[ol++]=k;
    del++;
    for(int i=l;i<nop-del;i++){
        ready_queue[i][0]=ready_queue[i+1][0];
        ready_queue[i][1]=ready_queue[i+1][1];
    }
    return k;
}

int findindex(int i){

}

int main(){
    printf("Enter Number of process : ");
    scanf("%d",&nop);
    for(int i=0;i<nop;i++){
        printf("\nEnter Arrival time of process %d :",i+1);
        scanf("%d",&ready_queue[i][0]);
    }
    for(int i=0;i<nop;i++){
        printf("\nEnter Burst time of process %d :",i+1);
        scanf("%d",&ready_queue[i][1]);
    }
    ready();
    int ct[nop],l=0;
    while(l<nop){
        if (ready_queue[0][0]<count ){
            count+=getminbt();
            ct[l++]=count;
        }else{
            count+=getminat();
            ct[l++]=count;
        }

    }
    for(int i=0;i<nop;i++){
        printf("%d\n",ct[i]);
    }
    int tat[nop],wt[nop],atat=0,awt=0;
    printf("\nPID AT BT CT TAT WT\n");
    for(int i=0;i<nop;i++){
        tat[i]=ct[i]-at[i];
        wt[i]=tat[i]-bt[i];
        atat+=tat[i];
        awt+=wt[i];
        printf("\n%d %d %d %d %d %d",i+1,at[i],bt[i],ct[i],tat[i],wt[i]);
    }
    printf("\nAverage Turn Around Time = %.2f",(float)atat/(float)nop);
    printf("\nAverage Waiting Time = %.2f\n",(float)awt/(float)nop);

}