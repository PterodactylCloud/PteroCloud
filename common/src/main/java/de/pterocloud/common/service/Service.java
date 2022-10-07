package de.pterocloud.common.service;

import de.pterocloud.common.packet.Packet;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class Service {

    private static final ServiceManager SERVICE_MANAGER = ServiceManager.getInstance();

    private final String id;

    private final List<String> tags;

    public Service(String id, List<String> tags) {
        this.id = id;
        this.tags = tags;
        register();
    }

    /**
     * Registers the service in the service manager
     */
    public void register() {
        SERVICE_MANAGER.sendPacket(new Packet()
                .put("type", "service")
                .put("id", id)
                .put("action", "register"));
    }

    /**
     * Unregisters the service from the service manager
     */
    public void unregister() {
        SERVICE_MANAGER.sendPacket(new Packet()
                .put("type", "service")
                .put("id", id)
                .put("action", "unregister"));
    }

    /**
     * Enables the service
     */
    public void enable() {
        SERVICE_MANAGER.sendPacket(new Packet()
                .put("type", "service")
                .put("id", id)
                .put("action", "enable"));
    }

    /**
     * Disables the service
     */
    public void disable() {
        SERVICE_MANAGER.sendPacket(new Packet()
                .put("type", "service")
                .put("id", id)
                .put("action", "disable"));
    }

    /**
     * Reloads the service
     */
    public void reload() {
        SERVICE_MANAGER.sendPacket(new Packet()
                .put("type", "service")
                .put("id", id)
                .put("action", "reload"));
    }

    public SubServiceImpl getSubService(String id) {
        return new SubServiceImpl(id, this);
    }

    /**
     * Registers a sub service
     *
     * @param subService the sub service
     */
    public void registerSubService(SubService subService) {
        subService.register();
    }

    /**
     * Unregisters a sub service
     *
     * @param subService the sub service
     */
    public void unregisterSubService(SubService subService) {
        subService.unregister();
    }

    /**
     * Enables a sub service
     *
     * @param subService the sub service
     */
    public void enableSubService(SubService subService) {
        subService.enable();
    }

    /**
     * Disables a sub service
     *
     * @param subService the sub service
     */
    public void disableSubService(SubService subService) {
        subService.disable();
    }

    /**
     * Reloads a sub service
     *
     * @param subService the sub service
     */
    public void reloadSubService(SubService subService) {
        subService.reload();
    }

    public abstract void onEnable();

    public abstract void onDisable();

    public abstract void onReload();

}
