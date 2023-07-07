import java.util.*;
class PlayFair{

    static void search(char mat[][], char a, char b, int index[]){
        if (a == 'j')
            a = 'i';
        else if (b == 'j')
            b = 'i';
        for (int i=0;i< 5;i++) {
            for (int j=0;j<5;j++) {
                if (mat[i][j] == a) {
                    index[0] = i;
                    index[1] = j;
                }else if (mat[i][j] == b) {
                    index[2] = i;
                    index[3] = j;
                }
            }
        }
    }
    public static void main(String[] argv){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a Keyword : ");
        String key = s.nextLine();
        char[] key_char  = key.toCharArray();
        char[][] mat = new char[5][5];
        for(int i=0;i<key.length()-1;i++){
            for(int j=i+1;j<key.length();j++){
                if(key_char[i]==key_char[j]){
                    key_char[j]='.';
                }
            }
        }
        int len=0;
        char[] array = new char[25];
        for(char x:key_char){
            if(x!='.'){
                array[len++] = x;
            }
        }
        char pass = 'a';
        while(pass<='z'){
            if(pass == 'j'){
                pass++;
                continue;
            }else{
                int k=0;
                for(int j=0;j<len;j++){
                    if(array[j]==pass){
                        k=1;
                    }
                }
                if(k==0){
                    array[len++]=pass;
                }
                pass++;
            }
        }
        len = 0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                mat[i][j] = array[len++];
                System.out.print(mat[i][j]+" ");
            }
            System.out.print("\n");
        }

        System.out.print("Enter Plain text : ");
        String plain = s.nextLine();
        char[] plain_char = plain.toCharArray();
        char[][] prep = new char[plain.length()*2][2];
        int  up = 0;
        for(int i=0;i<plain.length();){
            prep[up][0] =plain_char[i++];
            if(i==plain.length()){
                prep[up][1]='z';
                up++;
                break;
            }
            prep[up][1]=plain_char[i];
            if(prep[up][0] == prep[up][1]){
                prep[up][1] = 'x';
            }else{
                i++;
            }
            up++;
        }
        for(int i=0;i<up;i++){
            System.out.println(prep[i][0]+" "+prep[i][1]);
        }

        // plain text preparation and filler

        String cipher = "";
        for(int i=0;i<up;i++){
            int[] index =new int[4];
            search(mat, prep[i][0], prep[i][1], index);
            if (index[0] == index[2]) {
                cipher += mat[index[0]][(index[1] + 1)%5];
                cipher += mat[index[0]][(index[3] + 1)%5];
            }
            else if (index[1] == index[3]) {
                cipher += mat[(index[0] + 1)%5][index[1]];
                cipher += mat[(index[2] + 1)%5][index[1]];
            }
            else {
                cipher += mat[index[0]][index[3]];
                cipher += mat[index[2]][index[1]];
            }
        }
        System.out.println("Cipher Text : "+cipher);

    }
}