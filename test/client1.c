#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

int main() {
    int s = socket(AF_INET, SOCK_STREAM, 0);
    if(s<0){
        printf("[-]Error in connection.\n");
        exit(1);
    }
    printf("[+]Client Socket is created.\n");
    struct sockaddr_in a = {AF_INET, htons(4444), inet_addr("127.0.0.1")};
    int c = connect(s, (struct sockaddr*)&a, sizeof(a));
    if(c<0){
        printf("[-]Error in connection.\n");
        exit(1);
    }
    printf("[+]Connected to Server.\n");
    while (1) {
        char m[1024];
        printf("Client: \t");
        scanf("%s", m);
        send(s, m, strlen(m), 0);
        if (strcmp(m, ":exit") == 0)
        break;
        recv(s, m, sizeof(m), 0);
        printf("Server : \t%s\n", m);
    }
    close(s);
    return 0;
}
