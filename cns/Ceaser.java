import java.util.Scanner;
class Ceaser {
    public static void main(String[] argv){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = scanner.nextLine();
	    System.out.print("Enter Key Value : ");
        int key = scanner.nextInt();
        char[] array = s.toCharArray();
        int l = s.length();
        for(int i=0;i<l;i++){
            array[i] -= 97;
            array[i] = (char) (((int) array[i] + key)%26);
            array[i] += 97;
        }
        String str = new String();
        String t = str.valueOf(array);
        System.out.println("Cipher Text : "+t);
        for(int i=0;i<l;i++){
            array[i] -= 97;
            if((int)array[i] - key < 0){
                array[i] = (char)(26 + ((int)array[i] - key));
            }else{
                array[i] = (char) (((int) array[i] - key)%26);
            }
            array[i] += 97;
        }
        t = str.valueOf(array);
        System.out.println("Plain Text : "+t);

        scanner.close();

    }
}
