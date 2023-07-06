#include <assert.h>
#include <stdio.h>
int value(){
   static int i=0;
   printf("Address at scope is : %p\n",&i);
   i++;
   // printf("Address at after increment scope is : %p\n",&i);
   return i;
}
int main () {
   for(int i=0;i<5;i++){
   printf("Value a value is  %d\n",value());
   }
}