#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int check_authentication(char *password) {
	int auth_flag = 0;
	char password_buffer[16];
    // printf("\nPassword @ %p - %s \n",password,password);
	
    // printf("\nauth_flag @ %p - \n",&auth_flag);
	// int i=0;
    // printf("\nPassword buffer @ %p\n",password_buffer);
	strcpy(password_buffer, password);
	// int i=0;
	// printf("\nPassword buffer after cpy @ %p\n",password_buffer);
	// for(i;i<strlen(password_buffer);i++){
	// 	printf("%c @ %p\n",password_buffer[i],&password_buffer[i]);
	// }
	
	if(strcmp(password_buffer, "brillig") == 0)
		auth_flag = 1;
	if(strcmp(password_buffer, "outgrabe") == 0)
		auth_flag = 1;

	return auth_flag;
}

int main(int argc, char *argv[]) {
	// int i;
    // printf("Total args: %d\n", argc);
    // for(i=0; i<argc; i++){
    //     printf("#%d: %s\n", i, argv[i]);
    // }
    // printf("\nPassword in main @ %p\n",&argv[1]);
	if(argc < 2) {
		printf("Usage: %s <password>\n", argv[0]);
		exit(0);
	}
	if(check_authentication(argv[1])) {
		printf("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
		printf("      Access Granted.\n");
		printf("-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
	} else {
		printf("\nAccess Denied.\n");
    }
}
