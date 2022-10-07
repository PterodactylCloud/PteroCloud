package de.pterocloud.common.packet;

public class Packet {

    public Packet put(String key, Object value) {

        return this;
    }

    public Object get(String key) {
        return null;
    }

    public String serialize() {
        return "";
    }

    public static Packet deserialize(String serialized) {
        return null;
    }

}
