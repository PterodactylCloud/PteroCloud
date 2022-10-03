package de.pterocloud.master.service;

import lombok.Getter;

public abstract class SubService {

    @Getter
    private final String internalServiceId;

    public SubService(Service parent) {
        internalServiceId = parent.getInternalServiceId() + "#CHILD#" + this.getClass().getName();
    }

    public abstract void init() throws Exception;

    public abstract void shutdown() throws Exception;

}
