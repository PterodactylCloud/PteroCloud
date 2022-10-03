package de.pterocloud.master.command.commands;

import de.pterocloud.master.command.Command;
import de.pterocloud.master.command.CommandSender;
import org.jline.reader.Candidate;
import org.jline.reader.ParsedLine;

import java.util.List;

public class HelpCommand implements Command {
    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public String[] getAlias() {
        return new String[0];
    }

    @Override
    public String getDescription() {
        return "help";
    }

    @Override
    public String getPermission() {
        return "*";
    }

    @Override
    public Boolean run(String[] args, CommandSender sender) {
        sender.sendMessage("Help placeholder");
        return true;
    }

    @Override
    public String getHelp() {
        return "help";
    }

    @Override
    public List<Candidate> complete(ParsedLine line, List<Candidate> candidates) {
        return candidates;
    }
}
