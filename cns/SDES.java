import java.util.*;
class SDES{
    public static int[] ePermutation4={1,3,2,0};
    public static int[] initialPermutation8={1,5,2,0,3,7,4,6};
    public static int[] initialPermutation10={2,4,1,6,3,9,0,8,7,5};
    public static int[] ePermutation8={7,4,5,6,5,6,7,4};
    public static int[] ePermutation10= {5,2,6,3,7,4,9,8};
    public static int[] inverseInitialPermutation8={3,0,2,4,6,1,7,5};

    public static String permutate(char[] txt,int[] arr){
        String text = "";
        for(int i=0;i<arr.length;i++){
            text += txt[arr[i]];
        }
        return text;
    }

    public static String xor(char[] txt, char[] key){
        String text="";
        for(int i=0;i<txt.length;i++)
            text+= txt[i]==key[i] ? '0' : '1';
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

    public static int dec(char x, char y){
        return Integer.parseInt(""+x)*2 + Integer.parseInt(""+y);
    }
    public static String bin(int x){
        String[] val = {"00", "01", "10", "11"};
        return val[x];
    }
    
    public static String combine(char[] txt) {
        int[][] s0 = {
            { 1, 0, 3, 2 },
            { 3, 2, 1, 0 },
            { 0, 2, 1, 3 },
            { 3, 1, 3, 2 }
        };
        int[][] s1 = {
            { 0, 1, 2, 3 },
            { 2, 0, 1, 3 },
            { 3, 0, 1, 0 },
            { 2, 1, 0, 3 }
        };
        int p = dec(txt[0], txt[3]);
        int q = dec(txt[1], txt[2]);
        String text = bin(s0[p][q]);
        int r = dec(txt[4], txt[7]);
        int s = dec(txt[5], txt[6]);
        text += bin(s1[r][s]);
        return text;
    }

    public static String format(char[] text, String key1,String key2){
        String ip = permutate(text,initialPermutation8); 
        String ep = permutate(ip.toCharArray(),ePermutation8);
        String aftxor = xor(ep.toCharArray(), key1.toCharArray());
        String p4 = combine(aftxor.toCharArray());
        String ip4 = permutate(p4.toCharArray(),ePermutation4);
        String aftxor1 = xor((ip.substring(0, 4)).toCharArray(),ip4.toCharArray());
        String comrhip =  (ip.substring(4, 8)) + aftxor1;

        String ep1 = permutate(comrhip.toCharArray(),ePermutation8);
        String aftxor2 = xor(ep1.toCharArray(), key2.toCharArray());
        String p4_1 = combine(aftxor2.toCharArray());
        String ip4_1 = permutate(p4_1.toCharArray(),ePermutation4);
        String aftxor3 = xor((comrhip.substring(0, 4)).toCharArray(),ip4_1.toCharArray());
        String comrhip1 = aftxor3 + (comrhip.substring(4, 8));

        return permutate(comrhip1.toCharArray(),inverseInitialPermutation8);
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
        String key1 = permutate(shift(permutate(key.toCharArray(),initialPermutation10).toCharArray(),1).toCharArray(),ePermutation10);
        String key2 = permutate(shift(permutate(key.toCharArray(),initialPermutation10).toCharArray(),3).toCharArray(),ePermutation10);
        if (ch == 1) {
            System.out.println("Cipher Text : " + format(text.toCharArray(),key1,key2));
        }else{
            System.out.println("Cipher Text : " + format(text.toCharArray(),key2,key1));
        }
        s.close();
    }
}