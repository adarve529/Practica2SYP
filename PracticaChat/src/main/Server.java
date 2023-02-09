package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	  public static void main(String[] args) {
	    
		  FrameServidor window = new FrameServidor();
		  window.initialize();
		  
		  try {
	      ServerSocket serverSocket = new ServerSocket(3434);
	      System.out.println("Servidor iniciado, esperando conexiones");

	      Socket socket = serverSocket.accept();
	      System.out.println("Cliente conectado");

	      DataInputStream in = new DataInputStream(socket.getInputStream());
	      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

	      while (true) {
	        String message = in.readUTF();
	        System.out.println("Mensaje del cliente: " + message);

	        System.out.print("Escribe un mensaje: ");
	        Scanner scanner = new Scanner(System.in);
	        message = scanner.nextLine();

	        out.writeUTF(message);
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	}
