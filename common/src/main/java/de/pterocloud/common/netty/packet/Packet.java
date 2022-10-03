package de.pterocloud.common.netty.packet;

import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@Getter
public class Packet {

    private final UUID packetID = UUID.randomUUID();

    private final UUID sender;

    private final UUID receiver;

    private final Byte identifier;

    private final Object payload;

    public Packet(UUID sender, UUID receiver, Byte identifier, Serializable payload) {
        this.sender = sender;
        this.receiver = receiver;
        this.identifier = identifier;
        this.payload = payload;
    }

}