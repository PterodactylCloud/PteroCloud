package de.pterocloud.master.util;

import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

public class Splash {

    public static String Header = "ToDo";

    public static String FormattedHeader = new AttributedStringBuilder().style(AttributedStyle.DEFAULT.foreground(AttributedStyle.CYAN))
            .append(Header).style(AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW))
            .style(AttributedStyle.DEFAULT).toAnsi();

}
