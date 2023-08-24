import java.util.*;

class SDES {

    private static final int[] INITIAL_PERMUTATION_10 = {2, 4, 1, 6, 3, 9, 0, 8, 7, 5};
    private static final int[] E_PERMUTATION_10 = {5, 2, 6, 3, 7, 4, 9, 8};
    private static final int[] INITIAL_PERMUTATION_8 = {1, 5, 2, 0, 3, 7, 4, 6};
    private static final int[] INVERSE_INITIAL_PERMUTATION_8 = {3, 0, 2, 4, 6, 1, 7, 5};
    private static final int[] E_PERMUTATION_8 = {7, 4, 5, 6, 5, 6, 7, 4};
    private static final int[] E_PERMUTATION_4 = {1, 3, 2, 0};

    private static final int[][] S0 = {
            {1, 0, 3, 2},
            {3, 2, 1, 0},
            {0, 2, 1, 3},
            {3, 1, 3, 2}
    };

    private static final int[][] S1 = {
            {0, 1, 2, 3},
            {2, 0, 1, 3},
            {3, 0, 1, 0},
            {2, 1, 0, 3}
    };

    public static String permutation(char[] txt, int[] arr) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            text.append(txt[arr[i]]);
        }
        return text.toString();
    }

    public static String xor(char[] txt, char[] key) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < txt.length; i++) {
            text.append(txt[i] == key[i] ? '0' : '1');
        }
        return text.toString();
    }

    public static String combine(char[] txt) {
        int p = dec(txt[0], txt[3]);
        int q = dec(txt[1], txt[2]);
        String text = bin(S0[p][q]);

        int r = dec(txt[4], txt[7]);
        int s = dec(txt[5], txt[6]);
        text += bin(S1[r][s]);

        return text;
    }

    public static String shift(char[] txt, int x) {
        x %= txt.length;
        char[] result = new char[txt.length];
        System.arraycopy(txt, x, result, 0, txt.length - x);
        System.arraycopy(txt, 0, result, txt.length - x, x);
        return new String(result);
    }

    public static int dec(char x, char y) {
        return Integer.parseInt(String.valueOf(x)) * 2 + Integer.parseInt(String.valueOf(y));
    }

    public static String bin(int x) {
        return String.format("%02d", Integer.parseInt(Integer.toBinaryString(x)));
    }

    public static String process(char[] text, char[] key, int shift1, int shift2) {
        String key1 = ePermutation10(shift(initialPermutation10(key).toCharArray(), shift1).toCharArray());
        String key2 = ePermutation10(shift(initialPermutation10(key).toCharArray(), shift2).toCharArray());

        String ip = initialPermutation8(text);
        String ep = ePermutation8(ip.toCharArray());
        String aftxor = xor(ep.toCharArray(), key1.toCharArray());
        String p4 = combine(aftxor.toCharArray());
        String ip4 = ePermutation4(p4.toCharArray());
        char[] aftxor1 = xor(ip.toCharArray(), ip4.toCharArray()).toCharArray();

        String comrhip = aftxor1 + ip.substring(4, 8);

        String ep1 = ePermutation8(comrhip.toCharArray());
        String aftxor2 = xor(ep1.toCharArray(), key2.toCharArray());
        String p4_1 = combine(aftxor2.toCharArray());
        String ip4_1 = ePermutation4(p4_1.toCharArray());
        String aftxor3 = xor(comrhip.substring(0, 4).toCharArray(), ip4_1.toCharArray());
        String comrhip1 = aftxor3 + comrhip.substring(4, 8);

        return inverseInitialPermutation8(comrhip1.toCharArray());
    }

    public static String initialPermutation10(char[] txt) {
        return permutation(txt, INITIAL_PERMUTATION_10);
    }

    public static String ePermutation10(char[] txt) {
        return permutation(txt, E_PERMUTATION_10);
    }

    public static String initialPermutation8(char[] txt) {
        return permutation(txt, INITIAL_PERMUTATION_8);
    }

    public static String inverseInitialPermutation8(char[] txt) {
        return permutation(txt, INVERSE_INITIAL_PERMUTATION_8);
    }

    public static String ePermutation8(char[] txt) {
        return permutation(txt, E_PERMUTATION_8);
    }

    public static String ePermutation4(char[] txt) {
        return permutation(txt, E_PERMUTATION_4);
    }

    public static String encrypt(char[] text, char[] key) {
        return process(text, key, 1, 3);
    }

    public static String decrypt(char[] text, char[] key) {
        return process(text, key, 3, 1);
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a choice [1] - ENCRYPT / [2] - DECRYPT: ");
        int ch = s.nextInt();
        s.nextLine();
        System.out.print("Enter a text : ");
        String text = s.nextLine();
        System.out.print("Enter a key (10-bit binary): ");
        String keyInput = s.nextLine();
    
        // Ensure the key is exactly 10 bits long
        if (keyInput.length() != 10) {
            System.out.println("Error: Key must be 10 bits long.");
            s.close();
            return;
        }
    
        // Convert the binary key input to a character array
        char[] key = keyInput.toCharArray();
    
        if (ch == 1) {
            System.out.println("Cipher Text : " + encrypt(text.toCharArray(), key));
        } else {
            System.out.println("Plain Text : " + decrypt(text.toCharArray(), key));
        }
        s.close();
    }
    
}

// import java.util.*;
// class SDES{
//     public static String initialPermutation10(char[] txt){
//         //Rearrange this according to your wish
//         int[] arr={2,4,1,6,3,9,0,8,7,5};
//         String text = "";
//         for(int i=0;i<txt.length;i++){
//             text += txt[arr[i]];
//         }
//         return text;
//     }
//     public static String ePermutation10(char[] txt){
//         //Rearrange this according to your wish
//         int[] arr = {5,2,6,3,7,4,9,8};
//         String text = "";
//         for(int i=0;i<arr.length;i++){
//             text += txt[arr[i]];
//         }
//         return text;
//     }
//     public static String initialPermutation8(char[] txt){
//         //Rearrange this according to your wish
//         int[] arr={1,5,2,0,3,7,4,6};
//         String text = "";
//         for(int i=0;i<arr.length;i++){
//             text += txt[arr[i]];
//         }
//         return text;
//     }
//     public static String inverseInitialPermutation8(char[] txt){
//         //Rearrange this according to your wish
//         int[] arr={3,0,2,4,6,1,7,5};
//         String text = "";
//         for(int i=0;i<arr.length;i++){
//             text += txt[arr[i]];
//         }
//         return text;
//     }
//     public static String ePermutation8(char[] txt){
//         //Rearrange this according to your wish
//         int[] arr = {7,4,5,6,5,6,7,4};
//         String text = "";
//         for(int i=0;i<arr.length;i++){
//             text += txt[arr[i]];
//         }
//         return text;
//     }
//     public static String ePermutation4(char[] txt){
//         //Rearrange this according to your wish
//         int[] arr = {1,3,2,0};
//         String text = "";
//         for(int i=0;i<arr.length;i++){
//             text += txt[arr[i]];
//         }
//         return text;
//     }
//     public static String xor(char[] txt, char[] key){
//         String text="";
//         for(int i=0;i<txt.length;i++){
//             if(txt[i] == key[i]){
//                 text+='0';
//             }else{
//                 text+='1';
//             }
//         }
//         return text;
//     } 
//     public static String shift(char[] txt, int x) {
//         while (x > 0) {
//             x--;
//             String text = "";
//             for (int i = 1; i < txt.length / 2; i++) {
//                 text += txt[i];
//             }
//             text += txt[0];
//             for (int i = (txt.length / 2)+1; i < txt.length; i++) {
//                 text += txt[i];
//             }
//             text += txt[txt.length / 2];
//             txt = text.toCharArray();
//         }
//         return new String(txt);
//     }
//     public static int dec(char x, char y){
//         return Integer.parseInt(""+x)*2 + Integer.parseInt(""+y);
//     }
//     public static String bin(int x){
//         String[] val = {"00", "01", "10", "11"};
//         return val[x];
//     }
//     public static String combine(char[] txt) {
//         int[][] s0 = {
//             { 1, 0, 3, 2 },
//             { 3, 2, 1, 0 },
//             { 0, 2, 1, 3 },
//             { 3, 1, 3, 2 }
//         };
//         int[][] s1 = {
//             { 0, 1, 2, 3 },
//             { 2, 0, 1, 3 },
//             { 3, 0, 1, 0 },
//             { 2, 1, 0, 3 }
//         };
//         int p = dec(txt[0], txt[3]);
//         int q = dec(txt[1], txt[2]);
//         String text = bin(s0[p][q]);
//         int r = dec(txt[4], txt[7]);
//         int s = dec(txt[5], txt[6]);
//         text += bin(s1[r][s]);
//         return text;
//     }
    
//     public static String encrypt(char[] text, char[] key){
//         String key1 = ePermutation10(shift(initialPermutation10(key).toCharArray(),1).toCharArray());
//         String key2 = ePermutation10(shift(initialPermutation10(key).toCharArray(),3).toCharArray());

//         String ip = initialPermutation8(text); 
//         String ep = ePermutation8(ip.toCharArray());
//         String aftxor = xor(ep.toCharArray(), key1.toCharArray());
//         String p4 = combine(aftxor.toCharArray());
//         String ip4 = ePermutation4(p4.toCharArray());
//         String aftxor1 = xor((ip.substring(0, 4)).toCharArray(),ip4.toCharArray());
//         String comrhip =  (ip.substring(4, 8)) + aftxor1;

//         String ep1 = ePermutation8(comrhip.toCharArray());
//         String aftxor2 = xor(ep1.toCharArray(), key2.toCharArray());
//         String p4_1 = combine(aftxor2.toCharArray());
//         String ip4_1 = ePermutation4(p4_1.toCharArray());
//         String aftxor3 = xor((comrhip.substring(0, 4)).toCharArray(),ip4_1.toCharArray());
//         String comrhip1 = aftxor3 + (comrhip.substring(4, 8));

//         return inverseInitialPermutation8(comrhip1.toCharArray());
//     }

//     public static String decrypt(char[] text, char[] key){
//         String key1 = ePermutation10(shift(initialPermutation10(key).toCharArray(),1).toCharArray());
//         String key2 = ePermutation10(shift(initialPermutation10(key).toCharArray(),3).toCharArray());

//         String ip = initialPermutation8(text);
//         String ep = ePermutation8(ip.toCharArray());
//         String aftxor = xor(ep.toCharArray(), key2.toCharArray());
//         String p4 = combine(aftxor.toCharArray());
//         String ep0 = ePermutation4(p4.toCharArray());
//         String aftxor1 = xor((ip.substring(0, 4)).toCharArray(),ep0.toCharArray());
//         String comrhip = (ip.substring(4, 8)) + aftxor1 ;

        
//         String ep1 = ePermutation8(comrhip.toCharArray());
//         String aftxor2 = xor(ep1.toCharArray(), key1.toCharArray());
//         String p4_1 = combine(aftxor2.toCharArray());
//         String ep2 = ePermutation4(p4_1.toCharArray());
//         String aftxor3 = xor((comrhip.substring(0, 4)).toCharArray(),ep2.toCharArray());
//         String comrhip1 = aftxor3 + (comrhip.substring(4, 8));
        
//         return inverseInitialPermutation8(comrhip1.toCharArray());
//     }

//     public static void main(String args[]){
//         Scanner s = new Scanner(System.in);
//         System.out.print("Enter a choice [1] - ENCRYPT / [2] - DECRYPT: ");
//         int ch = s.nextInt();
//         s.nextLine();
//         System.out.print("Enter a text : ");
//         String text = s.nextLine();
//         System.out.print("Enter a key : ");
//         String key = s.nextLine();
//         if (ch == 1) {
//             System.out.println("Cipher Text : " + encrypt(text.toCharArray(), key.toCharArray()));
//         }else {
//             System.out.println("Plain Text : " + decrypt(text.toCharArray(), key.toCharArray()));
//         }
//         s.close();
//     }
// }