package org.compulsory;

import java.io.IOException;

public class ServerApplication {
    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
        server.SimpleServer();
    }
}