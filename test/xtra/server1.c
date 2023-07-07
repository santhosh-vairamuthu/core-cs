#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

int main() {
    int s = socket(AF_INET, SOCK_STREAM, 0), c, i;
    if(s<0){
        printf("[-]Error in connection.\n");
        exit(1);
    }
    printf("[+]Server Socket is created.\n");
    struct sockaddr_in a = {AF_INET, htons(4444), INADDR_ANY};
    int b = bind(s, (struct sockaddr*)&a, sizeof(a));
    if(b<0){
        printf("[-]Error in binding.\n");
        exit(1);
    }
    printf("[+]Bind to port 4444\n");
    if(listen(s, 10)==0){
        printf("[+]Listening....\n");
    }else{
        printf("[-]Error in listening.\n");
        exit(1);
    }
    c = accept(s, (struct sockaddr*)&a, (socklen_t*)&i);
    while (1) {
        char m[1024];
        recv(c, m, sizeof(m), 0);
        if (strcmp(m, ":exit") == 0) break;
        printf("Client: %s\n", m);
        send(c, m, strlen(m), 0);
    }
    close(c);
    return 0;
}
