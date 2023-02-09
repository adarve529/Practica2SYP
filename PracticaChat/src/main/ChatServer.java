package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

    static ArrayList<Socket> clientSockets;
    static ArrayList<String> userNames;

    public static void main(String[] args) {
    	
    	FrameServidor frameServer = new FrameServidor();
    	
        clientSockets = new ArrayList<>();
        userNames = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Servidor iniciado");

            while (true) {
                Socket socket = serverSocket.accept();
                clientSockets.add(socket);
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String name = dataInputStream.readUTF();
                userNames.add(name);
                System.out.println("Usuario conectado: " + name);
                ClientHandler clientHandler = new ClientHandler(socket, name);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private String name;

    public ClientHandler(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String received;
        while (true) {
            try {
                received = dataInputStream.readUTF();
                System.out.println(received);
                for (int i = 0; i < ChatServer.clientSockets.size(); i++) {
                    Socket temp = ChatServer.clientSockets.get(i);
                    DataOutputStream dataOutputStream = new DataOutputStream(temp.getOutputStream());
                    dataOutputStream.writeUTF(name + ": " + received);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

