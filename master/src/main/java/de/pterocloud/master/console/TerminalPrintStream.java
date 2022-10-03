package de.pterocloud.master.console;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.io.PrintStream;

public class TerminalPrintStream extends PrintStream {

    public TerminalPrintStream() {
        super(AnsiConsole.out);
    }

    @Override
    public void println(String s) {
        Console.reader.printAbove(s);
    }

    @Override
    public void print(String s) {
        Console.reader.printAbove(Ansi.ansi().cursorUpLine().eraseLine().a(s).toString());
    }


}
