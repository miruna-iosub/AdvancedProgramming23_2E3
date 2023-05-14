package org.compulsory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket = null;
    private String response;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request;
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            while((request = in.readLine()) != null){
            if(request.startsWith("stop")){
                response = "Server stopped!";
                System.out.println("Received the request: " + request);
                out.println(response);
                out.flush();
                System.exit(0);
                break;
            }
            else{
                response = "Server received the request: " + request + ".";
            }
        }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        }
    }
}