import java.util.*;
public class HillCipher{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Encryption [1]\nDecryption[2]\nEnter your choice : ");
        int n=sc.nextInt();
        sc.nextLine();
        if(n==1){
            System.out.print("Enter the plain text : ");
            String s=sc.nextLine();
            s=s.toLowerCase();
            int len=0,c=s.length()%3;
            for(int i=0;i<c;i++){
                s+="x";
            }
            char arr[] = s.toCharArray();
            String chiper = "";
            System.out.println("Enter the key : ");
            int key[][]= new int[3][3];
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    key[i][j]=sc.nextInt();
                }
                sc.nextLine();
            }
            int b=arr.length/3;
            for(int i=0;i<b;i++){
                int[][] mat = new int[3][1];
                int[][] result = new int[3][1];
                for(int j=0;j<3;j++){
                    mat[j][0] = arr[len++]-97;
                }
                for(int j=0;j<3;j++) {
                    for(int k=0;k<3;k++) {
                        result[j][0] += key[j][k]*mat[k][0];
                    }
                }
                for(int j=0;j<3;j++){
                    int y =  result[j][0];
                    if(y>=0){
                        y%=26;
                    }
                    else{
                        y*=-1;
                        y%=26;
                        if(y!=0){
                            y*=-1;
                            y = 26 + y;
                        }
                    }
                    char ch=(char)(y + 97);
                    chiper += ch;
                }
            }
            System.out.print("The cipher text is : "+chiper.substring(0,s.length()-c));
        }else{ 
            System.out.print("Enter the cipher text : ");
            String s=sc.nextLine();
            s=s.toLowerCase();
            int len=0,c=s.length()%3;
            for(int i=0;i<c;i++){
                s+="x";
            }
            char arr[] = s.toCharArray();
            String plain = "";
            System.out.println("Enter the key : ");
            int key[][] = new int[3][3];
            int adjacent[][] = new int [3][3];
            // int adj[][] = new int[3][3];
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    key[i][j]=sc.nextInt();
                }
                sc.nextLine();
            }
            int determinant=0;
            determinant = (key[0][0]*((key[1][1]*key[2][2])-(key[1][2]*key[2][1])));
            determinant -= (key[0][1]*((key[1][0]*key[2][2]) - (key[1][2]*key[2][0])));
            determinant += (key[0][2]*((key[1][0]*key[2][1])-(key[1][1]*key[2][0])));
            int inverse=0;
            for(int i=0;i<26;i++){
                if((determinant*i)%26==1){
                    inverse=i;
                }
            }
            if(inverse>0){
                inverse%=26;
            }else{
                inverse*=-1;
                inverse%=26;
                if(inverse!=0){
                    inverse*=-1;
                    inverse = 26 + inverse;
                }
            }
            adjacent[0][0] = ((key[1][1]*key[2][2])-(key[1][2]*key[2][1]));
            adjacent[1][0] = (-1) * ((key[1][0]*key[2][2])-(key[1][2]*key[2][0]));
            adjacent[2][0] = ((key[1][0]*key[2][1])-(key[1][1]*key[2][0]));
            adjacent[0][1] = (-1) * ((key[0][1]*key[2][2])-(key[0][2]*key[2][1]));
            adjacent[1][1] = ((key[0][0]*key[2][2])-(key[0][2]*key[2][0]));
            adjacent[2][1] = (-1) * ((key[0][0]*key[2][1])-(key[0][1]*key[2][0]));
            adjacent[0][2] = ((key[0][1]*key[1][2])-(key[0][2]*key[1][1]));
            adjacent[1][2] = (-1) * ((key[0][0]*key[1][2])-(key[0][2]*key[1][0]));
            adjacent[2][2] = ((key[0][0]*key[1][1])-(key[0][1]*key[1][0]));
            int b = arr.length/3;
            for(int i=0;i<b;i++){
                int[][] mat = new int[3][1];
                int[][] result = new int[3][1];
                for(int j=0;j<3;j++){
                    mat[j][0] = arr[len++]-97;
                }
                for(int j=0;j<3;j++) {
                    for(int k=0;k<3;k++) {
                        result[j][0]+=adjacent[j][k] * mat[k][0];
                    }
                }
                for(int j=0;j<3;j++){
                    int y = inverse *  result[j][0];;
                    if(y>=0){
                        y%=26;
                    }
                    else{
                        y*=-1;
                        y%=26;
                        if(y!=0){
                            y*=-1;
                            y = 26 + y;
                        }
                    }
                    char ch=(char)(y + 97);
                    plain += ch;
                }
            }
            System.out.print("The plain text is : "+plain.substring(0,s.length()-c));
        }
        sc.close();
    }
}
