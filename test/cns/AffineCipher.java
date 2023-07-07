import java.util.*;
class AffineCipher{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String plain = s.nextLine();
        System.out.print("Enter key value 'a' : ");
        int a = s.nextInt();
        s.nextLine();
        System.out.print("Enter key value 'b' : ");
        int b = s.nextInt();
        s.nextLine();
        String cipher = "";
        char[] plain_char = plain.toCharArray();
        for(int i=0;i<plain.length();i++){
            int y = plain_char[i] - 97;
            plain_char[i] = (char) (((a*y)+b)%26);
            plain_char[i]+= 97;
            // System.out.print((((a*y)+b)%26));
        }
        System.out.println("Cipher text : "+String.valueOf(plain_char));

        int c=0;
		for (int i = 0; i < 26; i++) {
            if (((a * i) % 26) == 1){
                c = i;
            }
        }
        for(int i=0;i<plain.length();i++){
            int y = plain_char[i] - 97;
            if((int)(c*(y-b))<0){
                plain_char[i] = (char)(26 + (c*(y-b)));
            }else{
                plain_char[i] = (char)((c*(y-b))%26);
            }
            plain_char[i]+= 97;
            // System.out.print((((a*y)+b)%26));
        }
        System.out.println("Plain text : "+String.valueOf(plain_char));

    }
}