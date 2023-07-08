import java.util.*;
public class HillCipher {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[][] mat = new int[3][3];
        System.out.print("Enter row 1 elements : ");
        mat[0][0]=s.nextInt();
        mat[0][1]=s.nextInt();
        mat[0][2]=s.nextInt();
        s.nextLine();
        System.out.print("Enter row 2 elements : ");
        mat[1][0]=s.nextInt();
        mat[1][1]=s.nextInt();
        mat[1][2]=s.nextInt();
        s.nextLine();
        System.out.print("Enter row 3 elements : ");
        mat[2][0]=s.nextInt();
        mat[2][1]=s.nextInt();
        mat[2][2]=s.nextInt();
        s.nextLine();
        System.out.print("Enter a plain text : ");
        String plain = s.nextLine();
        int c = plain.length()%3;
        while(c-- >= 0){
            plain+='x';
        }
        //System.out.println(plain);
        String cipher="";
        char[] plain_char = plain.toCharArray();
        for(int k=0;k<plain.length();k+=3){
            int[][] mul = new int[3][1];
            mul[0][0] = plain_char[k+0] - 97;
            mul[1][0] = plain_char[k+1] - 97;
            mul[2][0] = plain_char[k+2] - 97;
        }


    }
}

