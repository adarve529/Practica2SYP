package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("192.168.165.244", 3434);
      System.out.println("Conectado al servidor");

      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

      Scanner scanner = new Scanner(System.in);
      while (true) {
        System.out.print("Escribe un mensaje: ");
        String message = scanner.nextLine();

        out.writeUTF(message);

        message = in.readUTF();
        System.out.println("Mensaje del servidor: " + message);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
