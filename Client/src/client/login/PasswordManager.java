package client.login;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractMap.SimpleEntry;

public class PasswordManager {

   private static String id;
   private static String pass;

   private static SimpleEntry<String, SimpleEntry<String, String>> saved_account;

   public static void remember(String id, String pass) {
      saved_account = new SimpleEntry<>("true", new SimpleEntry<>(id, pass));
      try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("saved_account.sbdb"))) {
         oos.writeObject(saved_account);
         System.out.println("Password saved.");
      } catch (IOException e) {
         System.out.println("Error while saving password.");
         e.printStackTrace();
      }
   }

   private static boolean isPasswordSaved() {
      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("saved_account.sbdb"))) {
         saved_account = (SimpleEntry<String, SimpleEntry<String, String>>) ois.readObject();
         switch (saved_account.getKey()) {
            case "true":
               PasswordManager.id = saved_account.getValue().getKey();
               PasswordManager.pass = saved_account.getValue().getValue();
               System.out.println("Password read from disk.");
               return true;
            case "false":
               return false;
            default:
               break;
         }
      } catch (IOException | ClassNotFoundException e) {
         System.out.println("No saved account detected.");
      }
      return false;
   }

   public static String getId() {
      if (isPasswordSaved()) {
         return PasswordManager.id;
      } else {
         return null;
      }
   }

   public static String getPassword() {
      if (isPasswordSaved()) {
         return PasswordManager.pass;
      } else {
         return null;
      }
   }

   public static void removeSavedAccount() {   
      saved_account = new SimpleEntry<>("false", new SimpleEntry<>(null, null));
      try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("saved_account.sbdb"))) {
         oos.writeObject(saved_account);
         System.out.println("Account removed.");
      } catch (IOException e) {
         System.out.println("[Error Location]removeSavedAccount()");
         e.printStackTrace();
      }
   }
}
