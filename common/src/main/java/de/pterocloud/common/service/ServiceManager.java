package de.pterocloud.common.service;

import de.pterocloud.common.packet.Packet;
import de.pterocloud.encryptedconnection.EncryptedClient;
import de.pterocloud.encryptedconnection.EncryptedConnection;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.function.Consumer;

public class ServiceManager {

    @Getter
    private static final ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(3);

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

    public void sendPacket(Packet packet) {
        try {
            masterConnection.send(new de.pterocloud.encryptedconnection.Packet(packet.serialize()));
        } catch (Exception exception) {
            throw new RuntimeException("Could not send packet to master", exception);
        }
    }

    public void requestData(String key, String id, Consumer<Object> consumer) {
        sendPacket(new Packet()
                .put("type", "data-request")
                .put("key", key)
                .put("id", id));
        executor.execute(() -> {

        });
    }

    private List<String> requestServiceTags(String serviceId) {
        sendPacket(new Packet()
                .put("type", "service")
                .put("id", serviceId)
                .put("action", "get-tags"));
    }

    public ServiceImpl getService(String id) {
        JSONO
        return new ServiceImpl(id, "");
    }

    public void registerService(Service service) {
        service.register();
    }

    public void unregisterService(Service service) {
        service.unregister();
    }

}
