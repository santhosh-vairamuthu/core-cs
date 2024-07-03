import java.util.Scanner;
public class Vigenere {
        public static void main(String[] argv){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Key Value : ");
        String k = scanner.nextLine();
        System.out.print("Enter a string : ");
        String s = scanner.nextLine();
        char[] array = s.toCharArray();
        int i=0,j=0,l=0;
        int keys[];
        keys = new int[k.length()];
        for(i=0;i<k.length();i++){
            keys[l++]=((int)(k.charAt(i)))-97;
        }
        for(i=0;i<s.length();i++){
            array[i] -= 97;
            array[i] = (char)(((int) array[i] + keys[j])%26);
            array[i] += 97;
            j++;
            if(j==(k.length())){
                j=0;
            }
        }
        String str = new String();
        String t = str.valueOf(array);
        System.out.println("Cipher text : "+t);
        for(i=0,j=0;i<s.length();i++){
            array[i] -= 97;
            if((int)array[i] - keys[j] < 0){
                array[i] = (char)(26 + ((int)array[i] - keys[j]));
            }else{
                array[i] = (char) (((int) array[i] - keys[j])%26);
            }
            array[i] += 97;
            j++;
            if(j==(k.length())){
                j=0;
            }
        }
        t = str.valueOf(array);
        System.out.println("Plain Text : "+t);
        scanner.close();
    }
}