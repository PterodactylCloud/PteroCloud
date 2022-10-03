package de.pterocloud.master.command.commands;

import de.pterocloud.master.command.Command;
import de.pterocloud.master.command.CommandManager;
import de.pterocloud.master.command.CommandSender;
import de.pterocloud.master.logger.Logger;
import org.jline.reader.Candidate;
import org.jline.reader.ParsedLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelpCommand implements Command {

    public HelpCommand() {
    }


    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public String[] getAlias() {
        return new String[]{"?"};
    }

    @Override
    public String getDescription() {
        return "Shows all available Commands";
    }

    @Override
    public String getPermission() {
        return null;
    }

    @Override
    public Boolean run(String[] args, CommandSender sender) {
        sender.sendMessage("Help placeholder");
        return null;
    }

    @Override
    public String getHelp() {
        return "help";
    }

    @Override
    public List<Candidate> complete(ParsedLine line, List<Candidate> candidates) {
        return null;
    }
}
