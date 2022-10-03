package de.pterocloud.master.logger;

import de.pterocloud.master.console.TerminalPrintStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InfoPrintStream extends TerminalPrintStream {

    @Override
    public void println(String msg) {
        log.info(msg);
    }

    @Override
    public void print(String msg) {
        log.info(msg);
    }

}
