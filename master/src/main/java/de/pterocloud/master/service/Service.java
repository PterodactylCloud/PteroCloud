package de.pterocloud.master.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public abstract class Service {

    @Getter
    private String internalServiceId;

    @Getter
    @Setter
    private boolean isActive = false;


    public Service(){
       internalServiceId = this.getClass().getName() + "#" + new Random().nextInt(9999);
   }

    public abstract void init() throws Exception;
    public abstract void shutdown() throws Exception;

}
