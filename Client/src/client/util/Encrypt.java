package client.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class Encrypt {

    public static String encryptText(String plainText, String keyFileName) throws Exception {
        // Read the key from the file
        SecretKey secretKey = readKeyFromFile(keyFileName);

        // Initialize the cipher for encryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt the text
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        // Encode the bytes to a Base64 string
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static SecretKey readKeyFromFile(String keyFileName) throws IOException {
        byte[] keyBytes = new byte[32]; // 256 bits = 32 bytes
        try (FileInputStream fis = new FileInputStream(keyFileName)) {
            fis.read(keyBytes);
        }
        return new SecretKeySpec(keyBytes, "AES");
    }

    /**
     * @param args An array of strings containing command-line argument. Pass
     * two arguments. First is expected to be any string that needs to be
     * encrypted followed by second argument which is also a string that
     * represents the file name which the Encrypt class will use to fetch the
     * stored key which will be used to encrypt the string. It is required since
     * the key is expected to be written in this file. Probably you should
     * provide the same file name that you used to to create key using KeySaver
     * class.
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Encrypt <plainText> <keyFileName>");
            return;
        }

        String plainText = args[0];
        String keyFileName = args[1];

        try {
            String encryptedText = encryptText(plainText, keyFileName);
            System.out.println("Encrypted Text: " + encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
