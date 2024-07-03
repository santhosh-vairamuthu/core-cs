#include<stdio.h>
#include<sys/shm.h> 
#include<sys/ipc.h> 
#include<stdlib.h> 
#include<unistd.h> 
#include<sys/wait.h> 

#define SHM_SIZE 32
#define SHM_KEY 2041

int main()
{
    int child, shmid, i; 
    char *shmptr;
    child = fork(); 
    
    if(child < 0) {
        perror("fork failed"); 
        exit(EXIT_FAILURE); 
    }

    if(!child)
    {
        shmid = shmget(SHM_KEY, SHM_SIZE, IPC_CREAT | 0666); 
        if(shmid < 0) {
            perror("shmget failed"); 
            exit(EXIT_FAILURE); 
        }

        shmptr = shmat(shmid, NULL, 0); 
        if(shmptr == (void *) -1) {
            perror("shmat failed"); 
            exit(EXIT_FAILURE); 
        }

        printf("Parent is writing\n");
        for(i = 0; i < 10; i++)
        {
            shmptr[i] = 'a' + i; 
            putchar(shmptr[i]);
        }
        printf("\n"); 
        exit(EXIT_SUCCESS); 
    }
    else
    {
        shmid = shmget(SHM_KEY, SHM_SIZE, 0666); 
        if(shmid < 0) {
            perror("shmget failed"); 
            exit(EXIT_FAILURE); 
        }

        shmptr = shmat(shmid, NULL, 0); 
        if(shmptr == (void *) -1) {
            perror("shmat failed"); 
            exit(EXIT_FAILURE); 
        }

        printf("Child is reading\n"); 
        for(i = 0; i < 10; i++) 
            putchar(shmptr[i]);
        printf("\n"); 

        wait(NULL);
        exit(EXIT_SUCCESS); 
    }
    return 0;
}
