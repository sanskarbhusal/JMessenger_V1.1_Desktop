package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Sanskar
 */
public class AccountServer {

   private static final int PORT = 1111;
   private static ConcurrentHashMap<String, String> accounts;
   static int count=0;

   public static void main(String[] a) {
      System.out.println("**************************************************************************");
      System.out.println("****************************" + ANSI_GREEN + "  Account Server  " + ANSI_RESET + "****************************");
      System.out.println("**************************************************************************");
      System.out.println();
      try (ServerSocket serverSocket = new ServerSocket(PORT)) {
         System.out.println("Listening at:\nPort:\t" + ANSI_YELLOW + PORT + ANSI_RESET + "\nIP:\t" + ANSI_CYAN + InetAddress.getLocalHost().getHostAddress() + ANSI_RESET);
         while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println(ANSI_GREEN + "[" + ANSI_RESET);
            System.out.println("Client connected");
            new ClientHandler(clientSocket).start();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private static class ClientHandler extends Thread {

      private Socket clientSocket;

      public ClientHandler(Socket clientSocket) {
         this.clientSocket = clientSocket;
      }

      public void run() {
         try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            String REQUEST = in.readLine();
            String ID = in.readLine();
            String PASSWORD;
            String RESPONSE = "false";//default value must be false for the algorithm. Don't change.
            String id_found = "false";
            switch (REQUEST) {
               case "FIND":
                  System.out.println("Received account search request");
                  accounts = Database.getDatabase();
                  for (Map.Entry<String, String> entry : accounts.entrySet()) {
                     if (entry.getKey().equals(ID)) {
                        out.write("true");
                        out.newLine();
                        out.flush();
                        RESPONSE = "true";
                        System.out.println("Response protocol:[" + "true" + "]");
                        break;
                     }
                  }
                  if (RESPONSE.equals("false")) {
                     out.write("false");
                     out.newLine();
                     out.flush();
                     System.out.println("Response protocol:[" + "false" + "]");
                  }
                  break;
               case "LOGIN":
                  System.out.println("Received login request");
                  PASSWORD = in.readLine();
                  accounts = Database.getDatabase();
                  for (Map.Entry<String, String> entry : accounts.entrySet()) {
                     if (entry.getKey().equalsIgnoreCase(ID)) {
                        id_found = "true";
                        if (entry.getValue().equals(PASSWORD)) {
                           out.write("true");
                           out.newLine();
                           out.flush();
                           System.out.println("Login accepted");
                           RESPONSE = "true";
                           break;
                        } else {
                           out.write("WRONG_PASSWORD");
                           out.newLine();
                           out.flush();
                           break;
                        }
                     }
                  }
                  if (id_found.equals("false")) {
                     out.write("NO_ACCOUNT");
                     out.newLine();
                     out.flush();
                     break;
                  }
                  System.out.println("Response protocol:[" + RESPONSE + "]");
                  count++;
                  System.out.println("count: "+count);
                  break;
               case "REGISTER":
                  System.out.println("Received registration request");
                  PASSWORD = in.readLine();
                  accounts = Database.getDatabase();
                  for (Map.Entry<String, String> entry : accounts.entrySet()) {
                     RESPONSE = "true";
                     if (entry.getKey().equalsIgnoreCase(ID)) {
                        out.write("false");
                        out.newLine();
                        out.flush();
                        break;
                     }
                  }
                  if (RESPONSE.equals("true")) {
                     Database.add(ID, PASSWORD);
                     out.write("true");
                     out.newLine();
                     out.flush();
                     System.out.println("Registration allowed");
                  } else {
                     System.out.println("Registration declined");
                  }
                  System.out.println("Response protocol:[" + RESPONSE + "]");
                  break;
               default:
                  out.write("INVALID_REQUEST");
                  out.newLine();
                  out.flush();
                  System.out.println("[Invalid protocol] Probably an attack!");
                  break;
            }

         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            System.out.println("Client Disconnected");
            System.out.println(ANSI_GREEN + "]" + ANSI_RESET);
         }
      }
   }

   // ANSI escape codes for colors
   static String ANSI_RESET = "\u001B[0m";     // Reset color
   static String ANSI_RED = "\u001B[31m";      // Red color
   static String ANSI_GREEN = "\u001B[32m";    // Green color
   static String ANSI_YELLOW = "\u001B[33m";   // Yellow color
   static String ANSI_BLUE = "\u001B[34m";     // Blue color
   static String ANSI_CYAN = "\u001B[36m";
}
