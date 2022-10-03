package de.pterocloud.master.logger;


import de.pterocloud.master.service.Service;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.io.PrintStream;

public class Logger extends Service {

    private PrintStream out;

    private PrintStream err;

    @Override
    public void init() throws Exception {
        out = System.out;
        err = System.err;
        System.setOut(new InfoPrintStream());
        System.setErr(new ErrorPrintStream());
    }

    @Override
    public void shutdown() throws Exception {
        System.setOut(out);
        System.setErr(err);
    }
}
