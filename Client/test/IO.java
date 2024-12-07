
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class IO {

    public static void main(String l[]) {
        ;
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream("file"));
            writer.print(true);
            writer.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("file")));
            System.out.println(in.read());
            System.out.println(in.read());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
