package de.pterocloud.master.command.commands;

import de.pterocloud.master.command.Command;
import de.pterocloud.master.command.CommandSender;
import de.pterocloud.master.console.TerminalAppender;
import org.jline.reader.Candidate;
import org.jline.reader.ParsedLine;

import java.util.List;

public class DebugCommand implements Command {
    @Override
    public String getCommand() {
        return "debug";
    }

    @Override
    public String[] getAlias() {
        return new String[0];
    }

    @Override
    public String getDescription() {
        return "Change the LogLevel";
    }

    @Override
    public String getPermission() {
        return "*";
    }

    @Override
    public Boolean run(String[] args, CommandSender sender) {
        if (TerminalAppender.debug){
            TerminalAppender.debug = false;
            sender.sendMessage("Debug Log hidden");
        }else {
            TerminalAppender.debug = true;
            sender.sendMessage("Debug Log visible");
        }
        return true;
    }

    @Override
    public String getHelp() {
        return "Debug";
    }

    @Override
    public List<Candidate> complete(ParsedLine line, List<Candidate> candidates) {
        return candidates;
    }
}
