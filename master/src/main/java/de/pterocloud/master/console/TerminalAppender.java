package de.pterocloud.master.console;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.encoder.Encoder;
import lombok.Getter;
import lombok.Setter;

public class TerminalAppender extends AppenderBase<ILoggingEvent> {

    @Getter
    @Setter
    protected Encoder<ILoggingEvent> encoder;

    public static boolean debug = false;

    @Override
    protected void append(ILoggingEvent eventObject) {

       if(eventObject.getLevel().levelStr.equalsIgnoreCase("DEBUG") && debug == false){
           return;
       }

        Console.reader.printAbove(new String(encoder.encode(eventObject)));
    }
}