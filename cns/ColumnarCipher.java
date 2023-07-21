import java.util.*;
public class ColumnarCipher {
    public static String encrypt(String text,int[] arr){
        char[][] mat = new char[arr.length][arr.length];
        char[] plain = text.toCharArray();
        int l=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(l  == text.length()){
                    mat[i][j]='x';
                }else{
                    mat[i][j] = plain[l++];
                }
            }
        }
        String cipher = "";
        for(int i=0;i<arr.length;i++){
            int k=0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]==i){
                    k=j;
                }
            }
            for(int j=0;j<arr.length;j++){
                cipher+=mat[j][k];
            }
        }
        return cipher;
    }
    public static String decrypt(String text,int[] arr){
        char[][] mat = new char[arr.length][arr.length];
        char[] cipher = text.toCharArray();
        int l=0;
        for(int i=0;i<arr.length;i++){
            int k=0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]==i){
                    k=j;
                }
            }
            for(int j=0;j<arr.length;j++){
                mat[j][k] = cipher[l++];
            }
        }
        String plain = "";
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                    plain+=mat[i][j];
            }
        }
        return plain;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a choice [1] - ENCRYPT / [2] - DECRYPT: ");
        int ch = s.nextInt();
        s.nextLine();
        System.out.print("Enter a key : ");
        String key = s.nextLine();
        System.out.print("Enter a plain text : ");
        String text  = s.nextLine();
        char[] b = key.toCharArray();
        char[] c = key.toCharArray();
        Arrays.sort(b,0,b.length-1);
        int[] arr = new int[b.length];
        for(int i=0;i<b.length;i++){
            int k=0;
            for(int j=0;j<b.length;j++){
                if(c[i]==b[j]){
                    k=j;
                    break;
                }
            }
            arr[i] = k;
        }
        if(ch==1){
            System.out.println("Cipher text  : "+encrypt(text,arr));
        }else{
            System.out.println("Plain text  : "+decrypt(text,arr));
        }
    }
}
