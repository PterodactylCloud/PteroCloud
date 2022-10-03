package de.pterocloud.common.netty.packet;

public interface PacketListener {

    void onPacketReceive(Packet packet);

}
