package de.pterocloud.master.console;

import de.pterocloud.master.command.Command;
import de.pterocloud.master.command.CommandManager;
import de.pterocloud.master.service.SubService;
import de.pterocloud.master.util.SystemInformation;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.fusesource.jansi.Ansi;
import org.jline.reader.*;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public class Console extends SubService {

    private CommandManager commandManager;

    @Getter
    private Terminal terminal;

    protected static LineReader reader;

    private Thread thread;

    private String user = SystemInformation.getUserName();
    private String systemName = SystemInformation.getComputerName();


    Timer t;
    int timer = 0;
    boolean stop = true;

    @Setter
    private Boolean liveExecute = true;

    @Setter
    private ConsoleHandler customConsoleHandler;

    private String prompt = Ansi.ansi()
            .fg(Ansi.Color.CYAN)
            .a(Ansi.Attribute.INTENSITY_BOLD)
            .a(user + "@" + systemName)
            .fg(Ansi.Color.MAGENTA)
            .a(" >>> ")
            .toString();

    private String prompt2 = new AttributedStringBuilder()
            .style(AttributedStyle.DEFAULT.foreground(AttributedStyle.RED).bold()).append(user).style(AttributedStyle.DEFAULT).append("@")
            .style(AttributedStyle.DEFAULT.foreground(AttributedStyle.CYAN).bold()).append(systemName)
            .style(AttributedStyle.DEFAULT.foreground(AttributedStyle.MAGENTA).bold()).append(" >>> ").style(AttributedStyle.DEFAULT).toAnsi();


    public Console(CommandManager commandManager) {
        super(commandManager);
        this.commandManager = commandManager;
    }


    @Override
    public void init() throws Exception {
        terminal = TerminalBuilder.terminal();
        reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .completer(new Completer() {
                    @Override
                    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
                        if (line.line().equals("") || line.words().size() <= 1){
                            for (Command commands : commandManager.getCommands()){
                                candidates.add(new Candidate(commands.getCommand()));
                            }
                        }else {
                            for (Command command : commandManager.getCommands()){
                                if (line.words().get(0).equalsIgnoreCase(command.getCommand())){
                                    candidates.addAll(command.complete(line,candidates));
                                }
                            }
                        }
                    }
                })
                .build();

        t = new Timer();
    }

    public String getConsole(){
        try {
            String line = reader.readLine(prompt2);
            if (line != null){

                return line;
            }else {
                return "...";
            }
        }catch (Exception e){
            if (e instanceof UserInterruptException && !stop){
                log.info("Stopping JaLuMuCloud (press ENTER to abort)");
                timer = 5;
                stop = true;
                t.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        log.info("Stopping in " + timer);
                        if (timer <= 0){
                            System.exit(0);
                        }
                        timer--;
                    }
                },0,1000);

                System.console().readLine();

                t.cancel();
                stop = false;
                t = null;
                t = new Timer();
                log.info("Shutdown aborted");

                return "...";
            }else {
                return "...";
            }
        }
    }

    public void startListener(){

        if (!stop){
            return;
        }

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (thread.isAlive() && !thread.isInterrupted()){
                    handleConsole(getConsole());
                }
            }
        });

        stop = false;
        thread.start();
    }



    private void handleConsole(String readLine){

        if (liveExecute){
            commandManager.RunCommand(new ConsoleSender(),readLine);
        }else {
            customConsoleHandler.onConsoleInput(readLine);
        }

    }

    protected Console getConsoleListener(){
        return this;
    }


    @Override
    public void shutdown() throws Exception {
        stop = true;
        if (thread.isAlive()){
            thread.interrupt();
        }
    }
}
