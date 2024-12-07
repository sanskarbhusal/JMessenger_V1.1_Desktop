package client.login;

import client.util.Hash;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author Sanskar
 */
public class Account {

   private static final int PORT = 1111;
   private static final String address ="192.168.137.1";
   private static String id;
   private static String password;

   public static String isValid(String id, String pass) {
      try (Socket socket = new Socket(address, PORT);) {
         try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out.write("LOGIN");
            out.newLine();
            out.write(id);
            out.newLine();
            out.write(Hash.getBase64EncodedHash(pass));
            out.newLine();
            out.flush();
            return in.readLine();//returns the response message from AccountServer
         } catch (Exception e) {
            //inner catch block
            System.out.println("Cannot read/write into the socket!");
            e.printStackTrace();
            return "";
         }
      } catch (Exception e) {
         //outer catch block 
         System.out.println("Connection error!");
         e.printStackTrace();
         return "";
      }
   }

   public static String isUnique(String id, String pass) {
      try (Socket socket = new Socket(address, PORT)) {
         try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out.write("REGISTER");
            out.newLine();
            out.write(id);
            out.newLine();
            out.write(Hash.getBase64EncodedHash(pass));
            out.newLine();
            out.flush();
            return in.readLine();//returns the response message from AccountServer

         } catch (Exception e) {
            //inner catch block
            System.out.println("Cannot read/write into the socket!");
            e.printStackTrace();
            return "";
         }
      } catch (Exception e) {
         //outer catch block 
         System.out.println("Connection error!");
         e.printStackTrace();
         return "";
      }
   }

   public static String findAccount(String id) {
      String response = "";
      try (Socket socket = new Socket(address, PORT)) {
         try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out.write("FIND");
            out.newLine();
            out.flush();
            out.write(id);
            out.newLine();
            out.flush();
            response = in.readLine();

         } catch (Exception e) {
            System.out.println("[Location]findAccount()");
            e.printStackTrace();
         }
      } catch (Exception e) { 
         System.out.println("[Location]findAccount()");
         e.printStackTrace();
      }
      return response;
   }
}
