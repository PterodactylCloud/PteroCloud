package de.pterocloud.master.command.commands;

import de.pterocloud.master.command.Command;
import de.pterocloud.master.command.CommandSender;
import lombok.SneakyThrows;
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
    @SneakyThrows
    public Boolean run(String[] args, CommandSender sender) {
        sender.sendMessage("Testing netty...");

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
