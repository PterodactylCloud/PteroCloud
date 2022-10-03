package de.pterocloud.common.netty;


import de.pterocloud.common.netty.server.ChatServer;

public class Main {

    public static void main(String[] args) throws Exception {
        ChatServer server = new ChatServer(1607);
        server.start();
    }
}
