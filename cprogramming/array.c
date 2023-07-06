#include<stdio.h>
int len;

int ispresent(int arr[],int e){
    int f=0;
    for(int i=0;i<len;i++){
        if(arr[i]==e){
            f=1;
        }
    }
    return f;

}
void Traversing(int arr[]){
    for(int i=0;i<len;i++){
        printf("Element - %d Index - %d\n",arr[i],i);
    }
}

void Insertion(int arr[]){
    int position,element,k;
    printf("Enter the postion : ");
    scanf("%d",&position);
    printf("\nEnter the element : ");
    scanf("%d",&element);
    for(int i=position-1;i<len+1;i++){
        int k=arr[i];
        arr[i]=element;
        element=k;
    }

    for(int i=0;i<len+1;i++){
        printf("%d ",arr[i]);
    }

}

void Deletion(int arr[]){
    printf("Delete by Position - 1\nDelete by Element -2\n");
    int ch;
    printf("Enter your choise : \n");
    scanf("%d",&ch);
    if(ch==1){
        int pos;
        printf("\nEnter the position : ");
        scanf("%d",&pos);
        for(int i=pos-1;i<len;i++){
            arr[i]=arr[i+1];
        }
    }else{
        int element,f=0;
        printf("\nEnter the element to delete : ");
        scanf("%d",&element);
        if(ispresent(arr,element)){
            for(int i=0;i<len;i++){
                if(arr[i]==element){
                f=1;
                }
                if(f==1){
                    arr[i]=arr[i+1];
                }
            }

        }
    }
    for(int i=0;i<len-1;i++){
        printf("%d ",arr[i]);
    }

}

void Searching(int arr[]){
    int element;
    printf("\nEnter the element to find : ");
    scanf("%d",&element);
    if(ispresent(arr,element)){
        for(int i=0;i<len;i++){
            if(arr[i]==element)
                printf("\nElement - %d Index - %d",arr[i],i);
        }
    }else{
        printf("\nThe element is not present in the Array !!!\n");
    }
}

void Merge(int arr[]){
    int len2;
    printf("\nEnter the length of array 2 : ");
    scanf("%d",&len2);
    printf("\nEnter elements of array 2 : \n");
    int arr2[len2];
    for(int i=0;i<len2;i++){
        scanf("%d",&arr2[i]);
    }
    for(int i=len,j=0;j<len2;i++,j++){
        arr[i]=arr2[j];
    }
    for(int i=0;i<len+len2;i++){
        printf("%d ",arr[i]);
    }
}

void Sorting(int arr[]){
    for(int i=0;i<len;i++){
        for(int j=i+1;j<len;j++){
            if(arr[i]>arr[j]){
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
            }
        }
    }
    int ch;
    printf("\nAscending - 1\nDescending - 2\n");
    printf("Enter your choise : ");
    scanf("%d",&ch);
    printf("\n");
    if(ch==1){
        printf("\nAfter sorting in ascending order : \n");
        for(int i=0;i<len;i++){
            printf("%d ",arr[i]);
        }
    }else{
        printf("\nAfter sorting in descending order : \n");
        for(int i=len-1;i>=0;i--){
            printf("%d ",arr[i]);
        }
    }
}

int main(){
    printf("Enter Number of elements in th array : ");
    scanf("%d",&len);
    int arr[len*len];
    printf("Enter the array elements : \n");
    for(int i=0;i<len;i++){
        scanf("%d",&arr[i]);
    }
    printf("\nArray Traversing - 1\nArray Insertion - 2\nArray Deletion - 3\nArray Searching - 4\nArray Merging - 5\nArray Sorting -6 \n\n");
    int choise;
    printf("Enter your choise for array operation : ");
    scanf("%d",&choise);
    switch(choise){
        case 1:
            Traversing(arr);
            break;
        case 2:
            Insertion(arr);
            break;
        case 3:
            Deletion(arr);
            break;
        case 4:
            Searching(arr);
            break;
        case 5:
            Merge(arr);
            break;
        case 6:
            Sorting(arr);
            break;
        default:
            printf("\nInvalid choise !!!\n");
            break;


    }
}
