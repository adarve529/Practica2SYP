package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {
    	
    	FrameCliente frameClient = new FrameCliente();
        try {
            Socket socket = new Socket("localhost", 9800);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese su nombre: ");
            String name = scanner.nextLine();
            dataOutputStream.writeUTF(name);

            ReadMessageThread readMessageThread = new ReadMessageThread(dataInputStream);
            readMessageThread.start();

            while (true) {
                String message = scanner.nextLine();
                dataOutputStream.writeUTF(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReadMessageThread extends Thread {
    private DataInputStream dataInputStream;

    public ReadMessageThread(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = dataInputStream.readUTF();
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

