package org.compulsory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int PORT = 8100;

    public void SimpleServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Waiting for a client...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected at port: " + PORT);

                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        }
    }
}