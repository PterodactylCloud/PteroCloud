package de.pterocloud.master;

import de.pterocloud.master.command.CommandManager;
import de.pterocloud.master.logger.Logger;
import de.pterocloud.master.service.ServiceProvider;
import lombok.Getter;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;

import java.io.IOException;
import java.nio.file.Path;

public class Master {

    @Getter
    private static ServiceProvider serviceProvider;

    public static void main(String[] args) {
        System.setProperty("org.jline.terminal.dumb", "true");
        Logger logger = new Logger();
        serviceProvider = new ServiceProvider();
        serviceProvider.addService(logger);
        CommandManager commandManager = new CommandManager();
        serviceProvider.addService(commandManager);

    }
}
