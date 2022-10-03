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

    private CommandManager manager;

    private Logger logger;

    public HelpCommand(CommandManager manager){
        this.manager = manager;
    }


    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public String[] getAlias() {
        ArrayList list = new ArrayList<String>();
        list.add("hilfe");
        String[] alias = Arrays.copyOf(list.toArray(),list.size(),String[].class);
        return alias;
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
        for (Command c : manager.getCommands()){

        }
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
