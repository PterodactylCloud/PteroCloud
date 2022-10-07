package de.pterocloud.common.service;

import de.pterocloud.common.packet.Packet;
import lombok.Getter;

@Getter
@SuppressWarnings("unused")
public abstract class SubService {

    private static final ServiceManager SERVICE_MANAGER = ServiceManager.getInstance();

    private final String id;

    private final Service service;

    public SubService(String id, Service service) {
        this.id = id;
        this.service = service;
    }

    /**
     * Registers the subservice in the service manager
     */
    public void register() {
        SERVICE_MANAGER.sendPacket(new Packet()
                .put("type", "service")
                .put("id", service.getId())
                .put("action", "register-sub-service")
                .put("sub-service-id", id));
    }

    /**
     * Unregisters the subservice from the service manager
     */
    public void unregister() {
        SERVICE_MANAGER.sendPacket(new Packet()
                .put("type", "service")
                .put("id", service.getId())
                .put("action", "unregister-sub-service")
                .put("sub-service-id", id));
    }

    /**
     * Enables the subservice
     */
    public void enable() {
        SERVICE_MANAGER.sendPacket(new Packet()
                .put("type", "service")
                .put("id", service.getId())
                .put("action", "enable-sub-service")
                .put("sub-service-id", id));
    }

    /**
     * Disables the subservice
     */
    public void disable() {
        SERVICE_MANAGER.sendPacket(new Packet()
                .put("type", "service")
                .put("id", service.getId())
                .put("action", "disable-sub-service")
                .put("sub-service-id", id));
    }

    /**
     * Reloads the subservice
     */
    public void reload() {
        SERVICE_MANAGER.sendPacket(new Packet()
                .put("type", "service")
                .put("id", service.getId())
                .put("action", "reload-sub-service")
                .put("sub-service-id", id));
    }

    public abstract void onEnable();

    public abstract void onDisable();

    public abstract void onReload();

}
