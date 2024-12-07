
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Register {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        boolean registered = register(userId, password);

        if (registered) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("User ID already taken. Please choose a different one.");
        }
    }

    public static boolean register(String userId, String password) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("register");
            out.println(userId);
            out.println(password);

            String response = in.readLine();
            return "REGISTERED".equals(response);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}