// NOT YET COMPLETED
import java.util.*;
class SDES{
    public static String initialPermutation10(char[] txt){
        //Rearrange this according to your wish
        int[] arr={2,4,1,6,3,9,0,8,7,5};
        String text = "";
        for(int i=0;i<txt.length;i++){
            text += txt[arr[i]];
        }
        return text;
    }
    public static String ePermutation10(char[] txt){
        //Rearrange this according to your wish
        int[] arr = {5,2,6,3,7,4,9,8};
        String text = "";
        for(int i=0;i<arr.length;i++){
            text += txt[arr[i]];
        }
        return text;
    }
    public static String shift(char[] txt, int x) {
        while (x > 0) {
            x--;
            String text = "";
            for (int i = 1; i < txt.length / 2; i++) {
                text += txt[i];
            }
            text += txt[0];
            for (int i = (txt.length / 2)+1; i < txt.length; i++) {
                text += txt[i];
            }
            text += txt[txt.length / 2];
            txt = text.toCharArray();
        }
        return new String(txt);
    }
    
    
    public static void encrypt(char[] text, char[] key){
        String key1 = ePermutation10(shift(initialPermutation10(key).toCharArray(),1).toCharArray());
        String key2 = ePermutation10(shift(initialPermutation10(key).toCharArray(),3).toCharArray());
        System.out.println(key1);
        System.out.println(key2);
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a choice [1] - ENCRYPT / [2] - DECRYPT: ");
        int ch = s.nextInt();
        s.nextLine();
        System.out.print("Enter a text : ");
        String text = s.nextLine();
        System.out.print("Enter a key : ");
        String key = s.nextLine();
        if (ch == 1) {
            // System.out.println("Cipher Text : " + encrypt(text.toCharArray(), key.toCharArray()));
            encrypt(text.toCharArray(), key.toCharArray());
        }
        // } else {
        //     System.out.println("Plain Text : " + decrypt(text, key));
        // }
    }
}