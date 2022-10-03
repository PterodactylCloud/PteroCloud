package de.pterocloud.common.netty.packet;

import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

public class Packet {

    @Getter
    private final UUID packetID = UUID.randomUUID();
    @Getter
    private final UUID sender;
    @Getter
    private final UUID reciever;
    @Getter
    private final Object payload;

    public Packet(UUID sender,UUID reciever, Serializable payload) {
        this.sender = sender;
        this.reciever = reciever;
        this.payload = payload;
    }

}
