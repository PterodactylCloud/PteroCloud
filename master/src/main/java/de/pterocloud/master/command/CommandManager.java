package de.pterocloud.master.command;

import de.pterocloud.master.command.commands.DebugCommand;
import de.pterocloud.master.command.commands.HelpCommand;
import de.pterocloud.master.command.commands.TestCommand;
import de.pterocloud.master.console.Console;
import de.pterocloud.master.service.Service;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class CommandManager extends Service {

    @Getter
    private Console listener;

    @Getter
    private ArrayList<Command> commands;

    @Override
    public void init() throws Exception {
        commands = new ArrayList<>();
        listener = new Console(this);
        listener.init();
        registerCommand(new DebugCommand());
        registerCommand(new HelpCommand());
        registerCommand(new TestCommand());
    }

    public void registerCommand(Command command){
        commands.add(command);
    }

    public void unregisterCommand(Command command){
        commands.remove(command);
    }

    public boolean isCommandRegistered(Command command){
        return commands.contains(command);
    }

    public void RunCommand(CommandSender sender, String command){

        if (command.equals("") || command.equals("...")){
            return;
        }

        String[] args = command.split(" ");
        log.debug("Running Command: {}",command);
        for (Command c : commands){
            if (c.getCommand().equalsIgnoreCase(args[0])){
                if (sender.havePermission(c)){
                    if (!c.run(args,sender)){
                        helpHelper(c.getHelp());
                    }
                }
                return;
            }
        }

        for (Command c : commands){

            for (String s : c.getAlias()){

                if (s.equalsIgnoreCase(args[0])){
                    if (sender.havePermission(c)){
                        if (!c.run(args,sender)){
                            helpHelper(c.getHelp());
                        }
                    }
                    return;
                }

            }

        }
        log.info("Command not found");
    }

    public void helpHelper(String help){
        String[] split = help.split("\n");
        for (String s : split){
            log.info(s);
        }
    }


    @Override
    public void shutdown() throws Exception {
        listener.shutdown();
    }
}
