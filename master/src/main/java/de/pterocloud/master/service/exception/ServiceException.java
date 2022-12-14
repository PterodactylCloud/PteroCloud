package de.pterocloud.master.service.exception;

public class ServiceException extends Exception {

    private final String message;

    public ServiceException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
