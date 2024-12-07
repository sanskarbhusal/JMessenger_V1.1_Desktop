
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Login {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        boolean rememberMe = false;
        System.out.print("Remember me? (yes/no): ");
        String rememberMeInput = scanner.nextLine();
        if ("yes".equalsIgnoreCase(rememberMeInput)) {
            rememberMe = true;
        }

        boolean authenticated = authenticate(userId, password);

        if (authenticated) {
            System.out.println("Login successful!");
            if (rememberMe) {
                storeSession(userId, password);
            }
        } else {
            System.out.println("Login failed. Please check your credentials.");
        }
    }

    public static boolean authenticate(String userId, String password) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("login");
            out.println(userId);
            out.println(password);

            String response = in.readLine();
            return "SUCCESS".equals(response);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void storeSession(String userId, String password) {
        try (FileWriter fileWriter = new FileWriter("session.txt")) {
            fileWriter.write(userId + "\n" + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}