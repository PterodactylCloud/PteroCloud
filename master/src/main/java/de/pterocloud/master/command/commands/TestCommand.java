package de.pterocloud.master.command.commands;

import de.pterocloud.master.command.Command;
import de.pterocloud.master.command.CommandSender;
import de.pterocloud.master.console.TerminalAppender;
import org.jline.reader.Candidate;
import org.jline.reader.ParsedLine;

import java.util.List;

public class TestCommand implements Command {
    @Override
    public String getCommand() {
        return "test";
    }

    @Override
    public String[] getAlias() {
        return new String[0];
    }

    @Override
    public String getDescription() {
        return "Test";
    }

    @Override
    public String getPermission() {
        return "*";
    }

    @Override
    public Boolean run(String[] args, CommandSender sender) {
        sender.sendMessage("Debug Log hidden");
        return true;
    }

    @Override
    public String getHelp() {
        return "test";
    }

    @Override
    public List<Candidate> complete(ParsedLine line, List<Candidate> candidates) {
        return candidates;
    }
}
