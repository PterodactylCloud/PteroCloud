package de.pterocloud.master.util;

import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

public class Splash {

    public static String Header =
            "   __          __                        ___ _                 _ __           _                 \n" +
            "   \\ \\  __ _  / / _   _  /\\/\\  _   _    / __\\ | ___  _   _  __| / _\\_   _ ___| |_ ___ _ __ ___  \n" +
            "    \\ \\/ _` |/ / | | | |/    \\| | | |  / /  | |/ _ \\| | | |/ _` \\ \\| | | / __| __/ _ \\ '_ ` _ \\ \n" +
            " /\\_/ / (_| / /__| |_| / /\\/\\ \\ |_| | / /___| | (_) | |_| | (_| |\\ \\ |_| \\__ \\ ||  __/ | | | | |\n" +
            " \\___/ \\__,_\\____/\\__,_\\/    \\/\\__,_| \\____/|_|\\___/ \\__,_|\\__,_\\__/\\__, |___/\\__\\___|_| |_| |_|\n"+
            "                                                                    |___/ ";

    public static String FormattedHeader = new AttributedStringBuilder().style(AttributedStyle.DEFAULT.foreground(AttributedStyle.CYAN))
            .append(Header).style(AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW)).append("Powered by JaLuMu.de")
            .style(AttributedStyle.DEFAULT).toAnsi();

}
