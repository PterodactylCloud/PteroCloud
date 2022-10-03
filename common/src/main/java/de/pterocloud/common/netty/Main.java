package de.pterocloud.common.netty;


import de.pterocloud.common.netty.client.ChatClient;
import de.pterocloud.common.netty.server.ChatServer;

import java.util.UUID;

public class Main {

    public static void main() {
        ChatServer server = new ChatServer(1607);
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ChatClient client01 = new ChatClient(UUID.randomUUID(), "localhost", 1607, packet -> {
            System.out.println("Client 1: Received packet from " + packet.getSender() + " :" + packet.getPayload());
        });
        ChatClient client02 = new ChatClient(UUID.randomUUID(), "localhost", 1607, packet -> {
            System.out.println("Client 2: Received packet from " + packet.getSender() + " :" + packet.getPayload());
        });
        try {
            client01.start();
            client02.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
