import java.util.*;
public class RailCipher {
    public static String encrypt(String plain, int key) {
        char[] plain_char = plain.toCharArray();
        StringBuilder cipher = new StringBuilder();
        int l = 0, c = 0, k = 0;
        char[][] mat = new char[key][plain.length()];
        for (int i = 0; i < key; i++) {
            Arrays.fill(mat[i], '.');
        }
        while (l < plain.length()) {
            if (k == key - 1) {
                c = 1;
            } else if (k == 0) {
                c = 0;
            }
            mat[k][l] = plain_char[l++];
            k += c == 0 ? 1 : -1;
        }
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < plain.length(); j++) {
                if (mat[i][j] != '.') {
                    cipher.append(mat[i][j]);
                }
            }
        }
        return cipher.toString();
    }
    public static String decrypt(String cipher, int key) {
        char[] cipher_char = cipher.toCharArray();
        StringBuilder plain = new StringBuilder();
        int l = 0, c = 0, k = 0;
        char[][] mat = new char[key][cipher.length()];
        for (int i = 0; i < key; i++) {
            Arrays.fill(mat[i], '.');
        }
        while (l < cipher.length()) {
            if (k == key - 1) {
                c = 1;
            } else if (k == 0) {
                c = 0;
            }
            mat[k][l++] = '*';
            k += c == 0 ? 1 : -1;
        }
        l = 0;
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < cipher.length(); j++) {
                if (mat[i][j] == '*') {
                    mat[i][j] = cipher_char[l++];
                }
            }
        }
        l = 0;c = 0;k = 0;
        while (l < cipher.length()) {
            if (k == key - 1) {
                c = 1;
            } else if (k == 0) {
                c = 0;
            }
            plain.append(mat[k][l++]);
            k += c == 0 ? 1 : -1;
        }
        return plain.toString();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a choice [1] - ENCRYPT / [2] - DECRYPT: ");
        int ch = s.nextInt();
        s.nextLine();
        if (ch == 1) {
            System.out.print("Enter a plain text : ");
        } else {
            System.out.print("Enter a cipher text : ");
        }
        String text = s.nextLine();
        System.out.print("Enter a key : ");
        int key = s.nextInt();
        s.nextLine();
        if (ch == 1) {
            System.out.println("Cipher Text : " + encrypt(text, key));
        } else {
            System.out.println("Plain Text : " + decrypt(text, key));
        }
    }
}

