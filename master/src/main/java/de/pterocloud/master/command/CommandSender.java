package de.pterocloud.master.command;

public interface CommandSender {
    boolean havePermission(Command command);
    void sendMessage(String msg);
    void sendMessage();
}
