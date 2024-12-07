package client.util;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class Decrypt {

    public static String decryptText(String encryptedText, String keyFileName) throws Exception {
        // Read the key from the file
        SecretKey secretKey = readKeyFromFile(keyFileName);

        // Initialize the cipher for decryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Decode the Base64 string to bytes
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);

        // Decrypt the bytes
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        return new String(decryptedBytes);
    }

    private static SecretKey readKeyFromFile(String keyFileName) throws IOException {
        byte[] keyBytes = new byte[32]; // 256 bits = 32 bytes
        try (FileInputStream fis = new FileInputStream(keyFileName)) {
            fis.read(keyBytes);
        }
        return new SecretKeySpec(keyBytes, "AES");
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Decrypt <encryptedText> <keyFileName>");
            return;
        }

        String encryptedText = args[0];
        String keyFileName = args[1];
        
        try {
            String decryptedText = decryptText(encryptedText, keyFileName);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}