package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerStressTest {

   static int count = 0;
   static String response;
   static long start;
   static long end;
   static long duration;
   static long seconds;
   static long rps;
   static final String GREEN = "\u001B[32m";
   static final String YELLOW = "\u001B[33m";
   static final String RED = "\u001B[31m";
   static final String RESET = "\u001B[0m";
   static final String MAGENTA = "\u001B[35m";

   public static void main(String[] args) {
      start = System.nanoTime();
      while (true) {
         try (Socket socket = new Socket("192.168.137.1", 1111)) {
            try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
               out.write("LOGIN");
               out.newLine();
               out.write("id");
               out.newLine();
               out.write("password");
               out.newLine();
               out.flush();
               response = in.readLine();//returns the response message from AccountServer
               if (response != null) {
                  count = count + 1;
               }
               System.out.println("[Server responded] " + "Response count: " + count);
            } catch (IOException e) {
               System.out.println("[Couldn't send bytes]");
               break;
            }
         } catch (IOException e) {
            end = System.nanoTime();
            duration = end - start;
            seconds = duration / 1000000000;
            rps = count / seconds;
            System.out.println(RED + "[Failed]" + RESET);
            break;
         }
      }
      System.out.println(YELLOW + "**************" + MAGENTA + " stat " + YELLOW + "**************" + RESET);
      System.out.println("Requests handled: " + GREEN + count + RESET);
      System.out.println("Duration till first fail encounter: " + "~" + GREEN + seconds + " seconds" + RESET);
      System.out.println("Request handled per second: " + "~" + GREEN + rps + " RPS" + RESET);
   }

}
