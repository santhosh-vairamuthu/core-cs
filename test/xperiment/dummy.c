// // /**
// //  * Definition for singly-linked list.
// //  * struct ListNode {
// //  *     int val;
// //  *     struct ListNode *next;
// //  * };
// //  */
// //  struct ListNode* newnode(int d){
// //      struct ListNode *node = malloc(sizeof(struct ListNode));
// //      node->val = d;
// //      node->next = NULL;
// //      return node;
// //  }
// // struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
// //     struct ListNode* head=NULL,*tail=NULL;
// //     register  __uint128_t t,a=0,b=0,x=0,y=0,al1=0,al2=0;
// //     while(l1){
// //         if(l1->val == 0){
// //             al1++;
// //         }
// //         x = (x*10) + l1->val;
// //         l1 = l1->next;
// //     }
// //     while(l2){
// //         if(l2->val == 0){
// //             al2++;
// //         }
// //         y = (y*10) + l2->val;
// //         l2 = l2->next;
// //     }
// //     while(x){
// //         if(x%10 == 0){
// //             al1--;
// //         }
// //         a = (a*10) + (x%10);
// //         x/=10; 
// //     }
// //     while(y){
// //         if(y%10 == 0){
// //             al2--;
// //         }
// //         b = (b*10) + (y%10);
// //         y/=10;
// //     }
// //     while(al1--){
// //         a*=10;
// //     }
// //     while(al2--){
// //         b*=10;
// //     }
// //     t = a+b;
// //     if(t==0){
// //         head = newnode(0);
// //     }else{
// //         while(t){
// //             struct ListNode *node = newnode(t%10);
// //             t/=10;
// //             if(!head){
// //                 head=tail=node;
// //             }else{
// //                 tail->next=node;
// //                 tail=node;
// //             }
// //         }
// //     }
// //     return head;
// // }

// [2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9]
// [5,6,4,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9,9,9,9]