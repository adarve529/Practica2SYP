package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(3434);
      System.out.println("Servidor iniciado en el puerto 3434");

      Socket clientSocket = serverSocket.accept();
      System.out.println("Cliente conectado");

      DataInputStream in = new DataInputStream(clientSocket.getInputStream());
      DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

      while (true) {
        String message = in.readUTF();
        System.out.println("Mensaje recibido del cliente: " + message);

        if (message.equals("cerrar")) {
          System.out.println("Cerrando conexión con el cliente");
          break;
        }

        out.writeUTF("Mensaje del servidor: " + message);
      }

      clientSocket.close();
      serverSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
