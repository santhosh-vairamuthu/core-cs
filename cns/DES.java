import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DES {
    static String encrypt(String p_t, SecretKey key) throws Exception {
        Cipher ci = Cipher.getInstance("DES");
        ci.init(Cipher.ENCRYPT_MODE, key);
        byte[] text = p_t.replaceAll("[^a-zA-Z0-9]", "").getBytes(StandardCharsets.UTF_8);
        byte[] encby = ci.doFinal(text);
        return byteArrayToHexString(encby);
    }
    static String decrypt(String encText, SecretKey key) throws Exception {
        Cipher ci = Cipher.getInstance("DES");
        ci.init(Cipher.DECRYPT_MODE, key);
        byte[] encby = hexStringToByteArray(encText);
        byte[] decby = ci.doFinal(encby);
        String decText = new String(decby, StandardCharsets.UTF_8);
        decText = decText.replaceAll("[^a-zA-Z0-9]", "");
        return decText;
    }
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the plain text: ");
        String p_t = s.nextLine();
        System.out.print("\nEnter the key of 8 numbers: ");
        String keyText = s.nextLine();
        if (keyText.length() < 8)
            keyText = String.format("%-8s", keyText).replace(' ', '0');
        byte[] keyBytes = keyText.getBytes(StandardCharsets.UTF_8);
        DESKeySpec desKeySpec = new DESKeySpec(keyBytes);
        SecretKeyFactory keyFact = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFact.generateSecret(desKeySpec);
        String encText = encrypt(p_t, key);
        System.out.println("\nEncrypted: " + encText);
        String decText = decrypt(encText, key);
        System.out.println("\nDecrypted: " + decText);
        s.close();
    }
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
    private static byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }
}