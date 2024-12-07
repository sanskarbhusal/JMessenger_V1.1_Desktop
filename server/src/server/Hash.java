package server;

import java.security.MessageDigest;
import java.util.Base64;

/**
 *
 * @author Sanskar
 */
public class Hash {

    /**
     * @note Value of String variable "base64EncodedHash" needs to be
     * responsibly checked if it is going to be stored in database as password
     * because if the method getBase64EncodedHash() fails due to exception,
     * "null" will be assigned and returned which might be undesirable in the
     * case of password.
     */
    private static String base64EncodedHash;

    /**
     * @param string A string parameter which is hashed and then encoded into
     * base64 String.
     * @return The generated base64 String is then returned.
     */
    public static String getBase64EncodedHash(String string) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashByte = md.digest(string.getBytes());
            base64EncodedHash = Base64.getEncoder().encodeToString(hashByte);
        } catch (Exception e) {
            System.out.println("Problem occured while hashing password!");
            base64EncodedHash = null;
            System.err.println(e.getMessage());
        }
        return base64EncodedHash;
    }
}
