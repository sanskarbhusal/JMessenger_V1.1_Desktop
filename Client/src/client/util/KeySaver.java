package client.util;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class KeySaver {

    public static void createAndSaveKey(String fileName) throws NoSuchAlgorithmException, IOException {
        // Generate an AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // You can use 128 or 192 bits also
        SecretKey secretKey = keyGen.generateKey();

        // Save the key to a file
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(secretKey.getEncoded());
        }
    }

    /**
     * @param An array of strings containing command-line argument. Pass string
     * argument which will represent filename. It is required since the key is
     * supposed to be stored in a file. This file most probably will be read by
     * Encrypt and Decrypt class to fetch the key and use it to encrypt and
     * decrypt strings(or whatever).
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java KeySaver <keyFileName>");
            return;
        }

        String fileName = args[0];
        try {
            createAndSaveKey(fileName);
            System.out.println("Key saved to " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
