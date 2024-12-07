package server;

import java.io.*;
import java.net.*;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.concurrent.*;

public class ChatRelayServer {

   private static ConcurrentHashMap<String, Socket> onlineClients;
   private static ConcurrentLinkedQueue<SimpleImmutableEntry<String, SimpleImmutableEntry<String, String>>> routingTable;

   public static void main(String[] args) {
      int PORT = 2222;
      onlineClients = new ConcurrentHashMap<>();
      routingTable = new ConcurrentLinkedQueue<>();
      try (ServerSocket serverSocket = new ServerSocket(PORT)) {
         String ipAddress = InetAddress.getLocalHost().getHostAddress();
         System.out.println("Listening on:\nPort:\t" + ANSI_YELLOW + PORT + ANSI_RESET + "\nIP:\t" + ANSI_CYAN + ipAddress + ANSI_RESET);
         while (true) {
            Socket clientSocket = serverSocket.accept();
            new ClientHandler(clientSocket).start();
         }
      } catch (IOException e) {
         System.err.println(PORT + " Port already in use." + e.getMessage());
      }
   }

   private static class ClientHandler extends Thread {

      private final Socket clientSocket;
      private String sender_id;

      public ClientHandler(Socket clientSocket) {
         this.clientSocket = clientSocket;
      }

      public void run() {
         //reader thread
         Thread readerThread = new Thread(() -> {
            String dest_id;
            String rmsg;

            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
               //initial handshake
               sender_id = in.readLine();
               onlineClients.put(sender_id, clientSocket);
               System.out.println(sender_id + " online and ready to chat.");
               while (true) {
                  dest_id = in.readLine();
                  rmsg = in.readLine();
                  if (rmsg == null || rmsg == null) {
                     continue;
                  }
                  routingTable.add(new SimpleImmutableEntry<>(sender_id, new SimpleImmutableEntry<>(dest_id, rmsg)));
                  new RelayThread(onlineClients, routingTable).start();
                  System.out.println("client:" + rmsg);
               }
            } catch (Exception e) {
               System.err.println("Client offline." + e.getMessage());
            }
         });
         readerThread.start();
      }
   }

   private static class RelayThread extends Thread {

      ConcurrentLinkedQueue<SimpleImmutableEntry<String, SimpleImmutableEntry<String, String>>> routingTable;
      SimpleImmutableEntry<String, SimpleImmutableEntry<String, String>> routingTableRecord;
      ConcurrentHashMap<String, Socket> onlineClients;
      Socket receiver_socket;
      String sender_id;
      String receiver_id;
      String smsg;

      public RelayThread(ConcurrentHashMap onlineClients, ConcurrentLinkedQueue<SimpleImmutableEntry<String, SimpleImmutableEntry<String, String>>> routingTable) {
         this.onlineClients = onlineClients;
         this.routingTable = routingTable;
      }

      public void run() {
         while (true) {
            this.routingTableRecord = routingTable.poll();
            if (routingTableRecord == null) {
               System.out.println("[Relay Thread] No task at hand.");
               System.out.println("[Relay Thread] Self destruction initiated...");
               break;
            } else {
               sender_id = routingTableRecord.getKey();
               receiver_id = routingTableRecord.getValue().getKey();
               smsg = routingTableRecord.getValue().getValue();
               this.receiver_socket = onlineClients.get(receiver_id);
               try {
                  BufferedWriter out = new BufferedWriter(new OutputStreamWriter(receiver_socket.getOutputStream()));
                  out.write(sender_id);
                  out.newLine();
                  out.write(smsg);
                  out.newLine();
                  out.flush();
               } catch (IOException e) {
                  System.out.println("[Relay Thread] IOException while relaying message.");
                  System.out.println("[Possible Reason] Client went offline.");
               }
            }
         }
      }
   }
   // ANSI escape codes for colors
   private static final String ANSI_RESET = "\u001B[0m";     // Reset color
//   private static final String ANSI_RED = "\u001B[31m";      // Red color
//   private static final String ANSI_GREEN = "\u001B[32m";    // Green color
   private static final String ANSI_YELLOW = "\u001B[33m";   // Yellow color
//   private static final String ANSI_BLUE = "\u001B[34m";     // Blue color
   private static final String ANSI_CYAN = "\u001B[36m";     // Cyan color
}
