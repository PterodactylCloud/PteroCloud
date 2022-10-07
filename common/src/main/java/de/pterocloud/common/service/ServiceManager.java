package de.pterocloud.common.service;

import de.pterocloud.common.packet.Packet;
import de.pterocloud.encryptedconnection.EncryptedClient;
import de.pterocloud.encryptedconnection.EncryptedConnection;
import lombok.Getter;

public class ServiceManager {

    @Getter
    private static final ServiceManager instance = new ServiceManager("localhost", 5000);

    @Getter
    private final EncryptedConnection masterConnection;

    private ServiceManager(String masterHost, int masterPort) {
        try {
            EncryptedClient client = new EncryptedClient(masterHost, masterPort);
            client.connect();
            masterConnection = client.getEncryptedConnection();
        } catch (Exception exception) {
            throw new RuntimeException("Could not connect to master@" + masterHost + ":" + masterPort, exception);
        }
    }

    public void performQuery(String query) {

    }

    public void sendPacket(Packet packet) {
        try {
            masterConnection.send(new de.pterocloud.encryptedconnection.Packet(packet.serialize()));
        } catch (Exception exception) {
            throw new RuntimeException("Could not send packet to master", exception);
        }
    }

    public void registerService(Service service) {

    }

    public ServiceImpl getService(String id) {
        return null;
    }

}
