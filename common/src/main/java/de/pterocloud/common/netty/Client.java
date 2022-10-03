package de.pterocloud.common.netty;

import de.pterocloud.common.netty.client.ChatClient;
import de.pterocloud.common.netty.packet.Packet;

import java.util.UUID;

public class Client {

    public static void main(String[] args) throws Exception {
        ChatClient client = new ChatClient(UUID.randomUUID(), "localhost", 1607, packet -> {
            System.out.println("Client 1: Received packet from " + packet.getSender() + " :" + packet.getPayload());
        });
        client.start();

        client.sendPacket(new Packet(UUID.randomUUID(), UUID.randomUUID(), "Test"));
    }

}
