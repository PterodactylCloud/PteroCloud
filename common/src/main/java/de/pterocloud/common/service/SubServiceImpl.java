package de.pterocloud.common.service;

public class SubServiceImpl extends SubService {

    public SubServiceImpl(String id, Service service) {
        super(id, service);
    }

    @Override
    public void onEnable() {
        enable();
    }

    @Override
    public void onDisable() {
        disable();
    }

    @Override
    public void onReload() {
        reload();
    }

}
