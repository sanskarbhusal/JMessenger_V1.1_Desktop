package client.util;

import client.login.PasswordManager;
import java.io.*;
import java.util.*;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author Sanskar Bhusal
 */
public final class Database {

   /**
    * variable 'chatList' of type LinkedHashMap is supposed to store ID and the recent
    * chat associated with that ID. Unless the UI is changed in future, the chat list is
    * shown in the left side of the chat interface as of now.
    */
   private static ConcurrentLinkedDeque<SimpleImmutableEntry<String, String>> chatList;
   private static ConcurrentHashMap<String, ConcurrentLinkedDeque<SimpleImmutableEntry<String, String>>> messages;

   public Database(String arg) {
      Scanner scanner = new Scanner(System.in);
      switch (arg) {
         case "reset chatList" -> {
            while (true) {
               System.out.println("Enter password:");
               String pass = scanner.nextLine();
               if (pass.equals("admin")) {
                  resetChatList();
                  break;
               } else {
                  System.out.println("Wrong Password!!");
               }
            }
         }
         case "reset messages" -> {
            while (true) {
               System.out.println("Enter password:");
               String pass = scanner.nextLine();
               if (pass.equals("admin")) {
                  resetMessages();
                  break;
               } else {
                  System.out.println("Wrong Password!!");
               }
            }
         }
         case "list chat" -> {
            loadChatList();
            for (SimpleImmutableEntry<String, String> entry : chatList) {
               String key = entry.getKey();
               String value = entry.getValue();
               System.out.println("ID: " + key + ", Recent Message: " + value);
            }
         }
         default -> {
            break;
         }
      }
   }

   public static void resetChatList() {
      chatList = new ConcurrentLinkedDeque<>();
//      chatList.addLast(new SimpleImmutableEntry<>("new", "new"));
      updateChatList();
      System.out.println("Chat list reset :)");
   }

   public static void resetMessages() {
      messages = new ConcurrentHashMap<>();
//      ConcurrentLinkedDeque<SimpleImmutableEntry<String, String>> messageHistory = new ConcurrentLinkedDeque<>();
//      messageHistory.addLast(new SimpleImmutableEntry<>("sent", "[test message]"));
//      messageHistory.addLast(new SimpleImmutableEntry<>("received", "[test message]"));
//      messages.put("new", messageHistory);
      updateMessages();

//         messageHistory.addLast(new SimpleImmutableEntry<>("received", "hi"));
//         messageHistory.addLast(new SimpleImmutableEntry<>("sent", "hello"));
//         messages.put("put any thing except null and empty character", messageHistory);
//      updateMessages();
   }

   public static ConcurrentLinkedDeque<SimpleImmutableEntry<String, String>> getChatList() {
      loadChatList();
      return chatList;
   }

   public static ConcurrentHashMap<String, ConcurrentLinkedDeque<SimpleImmutableEntry<String, String>>> getMessages() {
      loadMessages();
      return messages;
   }

   private static void loadChatList() {
      if (!new File("chatList.sbdb").exists()) {
         System.out.println("Database file \"chatList.sbdb\" not found.");
         System.out.print("Press enter to exit...");
         new Scanner(System.in).nextLine();
         System.exit(0);
      }
      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("chatList.sbdb"))) {
         try {
            chatList = (ConcurrentLinkedDeque<SimpleImmutableEntry<String, String>>) ois.readObject();
            System.out.println("chatList loaded into memory");
         } catch (ClassNotFoundException e) {
            System.out.println("[location]loadChatList(): ClassNotFoundException");
            e.printStackTrace();
         }
      } catch (IOException e) {
         System.out.println("[location]loadChatList(): IOException");
         e.printStackTrace();
      }
   }

   private static void loadMessages() {
      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("messages.sbdb"))) {
         try {
            messages = (ConcurrentHashMap<String, ConcurrentLinkedDeque<SimpleImmutableEntry<String, String>>>) ois.readObject();
            System.out.println("messages loaded into memory");
         } catch (ClassNotFoundException e) {
            System.out.println("[location]loadMessages(): ClassNotFoundException");
            e.printStackTrace();
         }
      } catch (IOException e) {
         System.out.println("[location]loadMessages(): IOException");
         e.printStackTrace();
      }
   }

   public static void addToChatList(String id, String recentMessage) {
      loadChatList();
      for (SimpleImmutableEntry<String, String> entry : chatList) {
         if (entry.getKey().equals(id)) {
            chatList.remove(entry);
         }
      }
      chatList.addFirst(new SimpleImmutableEntry<>(id, recentMessage));
      updateChatList();

   }

   public static void addToMessages(String id, String message, String msg_type) {
      loadMessages();
      if (messages.containsKey(id)) {
         messages.get(id).addLast(new SimpleImmutableEntry<>(msg_type, message));
      } else {
         ConcurrentLinkedDeque<SimpleImmutableEntry<String, String>> msg_history = new ConcurrentLinkedDeque<>();
         msg_history.addLast(new SimpleImmutableEntry<>(msg_type, message));
         messages.put(id, msg_history);
      }
      updateMessages();
   }

   private static void updateChatList() {
      try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("chatList.sbdb"))) {
         out.writeObject(chatList);
         System.out.println("ID updated in the chatList Database");
      } catch (Exception e) {
         System.out.println("[location] updateChatList()");
         e.printStackTrace();
      }
   }

   private static void updateMessages() {
      try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("messages.sbdb"))) {
         out.writeObject(messages);
         System.out.println("Message updated in database.");
      } catch (Exception e) {
         System.out.println("[location] updateMessages()");
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      if (args.length == 1) {
         switch (args[0]) {
            case "reset chatList" -> {
               while (true) {
                  System.out.println("Enter password:");
                  String pass = scanner.nextLine();
                  if (pass.equals("admin")) {
                     resetChatList();
                     break;
                  } else {
                     System.out.println("Wrong Password!!");
                  }
               }
            }
            case "reset messages" -> {
               while (true) {
                  System.out.println("Enter password:");
                  String pass = scanner.nextLine();
                  if (pass.equals("admin")) {
                     resetMessages();
                     break;
                  } else {
                     System.out.println("Wrong Password!!");
                  }
               }
            }
            case "reset account" -> {
               PasswordManager.removeSavedAccount();
               break;
            }

            case "list chat" -> {
               loadChatList();
               for (SimpleImmutableEntry<String, String> entry : chatList) {
                  String key = entry.getKey();
                  String value = entry.getValue();
                  System.out.println("ID: " + key + ", Recent Message: " + value);
               }
            }
            default -> {
            }
         }

      } else {
         System.out.println("Syntax error! No parameter provided");
         System.out.println("Usage: Database  [parameter]");
         System.out.println("Parameter supported: reset, list chat");
         System.out.println("example:");
         System.out.println("Database reset");
         System.out.println("Database list chat");
      }

   }
}
