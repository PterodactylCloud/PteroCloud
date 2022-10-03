package de.pterocloud.master.service;

import java.util.ArrayList;
import java.util.Iterator;

public class ServiceProvider {

    private final ArrayList<Service> serviceRegistry;

    public ServiceProvider() {
        serviceRegistry = new ArrayList<>();
    }

    public void addService(Service service) {
        serviceRegistry.add(service);
    }

    public <T extends Service> T getService(final Class<T> type) {
        return type.cast(serviceRegistry.stream().filter(service -> service.getClass() == type).findFirst().orElse(null));
    }

    public Service getService(Class<?> service, String id) {
        for (Service s : serviceRegistry) {
            if (s.getClass().getName().equals(service.getName()) && s.getInternalServiceId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public int registeredServiceCount() {
        return serviceRegistry.size();
    }

    public void initAll() throws Exception {
        for (Service s : serviceRegistry) {
            s.init();
        }
    }

    public void stopAll() throws Exception {
        for (Iterator<Service> i = serviceRegistry.iterator(); i.hasNext(); ) {
            Service s = i.next();
            s.shutdown();
            i.remove();
        }
    }

}
