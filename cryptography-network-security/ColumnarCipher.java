import java.util.*;
public class ColumnarCipher {
    public static String encrypt(String text,int[] arr){
        char[] plain = text.toCharArray();
        int l=0;
        char[][] mat = new char[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(l == plain.length){
                    mat[i][j] = 'x';
                }else{
                    mat[i][j] = plain[l++];
                }
            }
        }
        String cipher = "";
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length; j++){
                cipher += mat[j][arr[i]];
            }
        }
        return cipher;
    }
    public static String decrypt(String text,int[] arr){
        char[] cipher = text.toCharArray();
        int l=0;
        char[][] mat = new char[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length; j++){
                mat[j][arr[i]] = cipher[l++];
            }
        }
        String plain = "";
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(l == cipher.length){
                    plain+=mat[i][j];
                }
            }
        }
        return plain;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a text : ");
        String text = s.nextLine();
        System.out.print("Enter a key: ");
        String key = s.nextLine();
        char[] b = key.toCharArray();
        char[] c = key.toCharArray();
        Arrays.sort(b,0,b.length-1);
        int[] arr = new int[b.length];
        for(int i=0;i<b.length;i++){
            int k=0;
            for(int j=0;j<b.length;j++){
                if(c[j]==b[i]){
                    k=j;
                    break;
                }
            }
            arr[i]=k;
        }
        System.out.println("Cipher Text : "+encrypt(text,arr));
        System.out.println("Plain Text : "+decrypt(encrypt(text,arr),arr).substring(0, text.length()));
        s.close();
    }
}
