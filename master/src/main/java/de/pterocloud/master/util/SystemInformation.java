package de.pterocloud.master.util;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class SystemInformation {

    public static String getUserName(){
        return System.getProperty("user.name");
    }

    public static String getComputerName(){
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "unknown";
    }

}
