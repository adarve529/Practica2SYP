package main;

import java.io.*;
import java.net.*;

public class ChatClient {
   public static void main(String[] args) throws IOException {
      Socket socket = null;
      PrintWriter out = null;
      BufferedReader in = null;
      try {
         socket = new Socket("192.168.165.244", 4444);
         out = new PrintWriter(socket.getOutputStream(), true);
         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      } catch (UnknownHostException e) {
         System.err.println("Unknown host: localhost");
         System.exit(1);
      } catch (IOException e) {
         System.err.println("No I/O");
         System.exit(1);
      }
      BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
      String userInput;
      while ((userInput = stdIn.readLine()) != null) {
         out.println(userInput);
         System.out.println("Server says: " + in.readLine());
      }
      out.close();
      in.close();
      stdIn.close();
      socket.close();
   }
}
