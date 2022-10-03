package de.pterocloud.master.console;

import de.pterocloud.master.command.Command;
import de.pterocloud.master.command.CommandSender;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleSender implements CommandSender {
    @Override
    public boolean havePermission(Command command) {
        return true;
    }

    @Override
    public void sendMessage(String msg) {
        log.info(msg);
    }

    @Override
    public void sendMessage() {
        log.info("");
    }

}
