package de.pterocloud.master.command;

import org.jline.reader.Candidate;
import org.jline.reader.ParsedLine;

import java.util.List;

public interface Command {

    String getCommand();
    String[] getAlias();
    String getDescription();
    String getPermission();
    Boolean run(String[] args,CommandSender sender);
    String getHelp();
    List<Candidate> complete(ParsedLine line,List<Candidate> candidates);


}
