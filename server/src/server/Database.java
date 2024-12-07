package server;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Sanskar Bhusal, a want-to-be programmer :)
 */
public final class Database {

    private static ConcurrentHashMap<String, String> database;

    public Database(String arg) {
        /**
         * TODO Do whatever! Just make sure that the constructor is private
         * because this class is supposed to be used as a utility class with
         * only static methods and fields. If it isn't, then be careful.
         */
        Scanner scanner = new Scanner(System.in);
        if (arg != null) {
            switch (arg) {
                case "reset" -> {
                    while (true) {
                        System.out.println("Enter password:");
                        String pass = scanner.nextLine();
                        if (pass.equals("admin")) {
                            reset();
                            break;
                        } else {
                            System.out.println("Wrong Password!!");
                        }
                    }
                }
                case "list entry" -> {
                    loadDatabase();
                    Iterator<Map.Entry<String, String>> iterator = database.entrySet().iterator();
                    System.out.println("Displaying entries from database");
                    System.out.println("-------------------------");
                    System.out.println("|ID\t|Password\t|");
                    System.out.println("-------------------------");
                    while (iterator.hasNext()) {
                        Map.Entry<String, String> entry = iterator.next();
                        String key = entry.getKey();
                        String value = entry.getValue();
                        System.out.println("|" + key + "\t|" + value + "\t\t|");
                    }
                    System.out.println("-------------------------");
                }
                default -> {
                }
            }

        } else {
            System.out.println("Syntax error! No parameter provided");
            System.out.println("Usage: Database  [parameter]");
            System.out.println("Parameter supported: reset, list entry");
            System.out.println("example:");
            System.out.println("Database reset");
            System.out.println("Database list entry");
        }

    }

    public static void reset() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("accounts.sbdb"))) {
            database = new ConcurrentHashMap<>();
            database.put("root", Hash.getBase64EncodedHash("root"));
            System.out.println("Database reset :)");
            oos.writeObject(database);
        } catch (Exception e) {
            System.out.println("Probable: Error while writing HashMap object to file.");
            e.printStackTrace();
        }
    }

    public static ConcurrentHashMap<String, String> getDatabase() {
        loadDatabase();
        return database;
    }

    private static void loadDatabase() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("accounts.sbdb"))) {
            database = (ConcurrentHashMap<String, String>) ois.readObject();
            System.out.println("Database loaded into memory");
            ois.close();
        } catch (Exception e) {
            System.out.println("Exception while loading database!");
            e.printStackTrace();
        }
    }

    public static void add(String id, String pass) {
        loadDatabase();
        database.put(id, pass);
        save();

    }

    private static void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("accounts.sbdb"))) {
            out.writeObject(database);
            System.out.println("Data Saved.");
        } catch (Exception e) {
            System.out.println("Error while saving hashmap to file.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (args.length == 1) {
            switch (args[0]) {
                case "reset" -> {
                    while (true) {
                        System.out.println("Enter password:");
                        String pass = scanner.nextLine();
                        if (pass.equals("admin")) {
                            reset();
                            break;
                        } else {
                            System.out.println("Wrong Password!!");
                        }
                    }
                }
                case "list entry" -> {
                    loadDatabase();
                    Iterator<Map.Entry<String, String>> iterator = database.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, String> entry = iterator.next();
                        String key = entry.getKey();
                        String value = entry.getValue();
                        System.out.println("Key: " + key + ", Value: " + value);
                    }
                }
                default -> {
                }
            }

        } else {
            System.out.println("Syntax error! No parameter provided");
            System.out.println("Usage: Database  [parameter]");
            System.out.println("Parameter supported: reset, list entry");
            System.out.println("example:");
            System.out.println("Database reset");
            System.out.println("Database list entry");
        }

    }
}