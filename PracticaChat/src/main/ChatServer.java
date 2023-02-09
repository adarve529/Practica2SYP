package main;

import java.io.*;
import java.net.*;

public class ChatServer {
   public static void main(String[] args) throws IOException {
      ServerSocket serverSocket = null;
      try {
         serverSocket = new ServerSocket(3561);
      } catch (IOException e) {
         System.err.println("Could not listen on port: 9800.");
         System.exit(1);
      }
      Socket clientSocket = null;
      System.out.println("Waiting for client...");
      try {
         clientSocket = serverSocket.accept();
      } catch (IOException e) {
         System.err.println("Accept failed.");
         System.exit(1);
      }
      System.out.println("Client connected.");
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(
                 new InputStreamReader(
                 clientSocket.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
         System.out.println("Client says: " + inputLine);
         out.println(inputLine);
      }
      out.close();
      in.close();
      clientSocket.close();
      serverSocket.close();
   }
}
