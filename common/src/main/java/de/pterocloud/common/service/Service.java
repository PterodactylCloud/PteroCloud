package de.pterocloud.common.service;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class Service {

    private final String id;

    private final List<String> tags;

    public Service(String id, List<String> tags) {
        this.id = id;
        this.tags = tags;
    }

    public void enable() {
        ServiceManager.performQuery("enable " + id);
    }

    public void disable() {
        ServiceManager.performQuery("disable " + id);
    }

    public void reload() {
        ServiceManager.performQuery("reload " + id);
    }

    public void registerSubService(SubService subService) {
        ServiceManager.performQuery("subservice register " + id + " " + subService.getId());
    }

    public abstract void onEnable();

    public abstract void onDisable();

    public abstract void onReload();

}
