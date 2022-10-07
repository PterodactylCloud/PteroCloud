package de.pterocloud.master;

import de.pterocloud.common.packet.Packet;
import de.pterocloud.encryptedconnection.EncryptedServer;
import de.pterocloud.master.command.CommandManager;
import de.pterocloud.master.logger.Logger;
import de.pterocloud.master.service.ServiceProvider;
import lombok.Getter;

public class Master {

    @Getter
    private static ServiceProvider serviceProvider;

    public static void main(String[] args) {
        System.setProperty("org.jline.terminal.dumb", "true");
        Logger logger = new Logger();
        serviceProvider = new ServiceProvider();
        serviceProvider.addService(logger);
        CommandManager commandManager = new CommandManager();
        serviceProvider.addService(commandManager);
        try {
            commandManager.init();
            commandManager.getListener().startListener();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            EncryptedServer encryptedServer = new EncryptedServer(5000);
            encryptedServer.start();
        } catch (Exception exception) {
            throw new RuntimeException("Failed to Start Cloud-Master", exception);
        }

        Packet packet = new Packet();
        packet.put("name", "jonas");
        packet.put("age", 15);
        packet.put("isCool", true);

        String serialized = packet.serialize();
        Packet deserialized = Packet.deserialize(serialized);
        System.out.println(deserialized.get("name"));
        System.out.println(deserialized.get("age"));
        System.out.println(deserialized.get("isCool"));
    }

}
