package de.pterocloud.common.service;

import java.util.List;

public class ServiceImpl extends Service {

    public ServiceImpl(String id, List<String> tags) {
        super(id, tags);
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onReload() {
    }

}
