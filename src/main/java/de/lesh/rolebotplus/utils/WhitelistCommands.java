package de.lesh.rolebotplus.utils;

import net.dv8tion.jda.core.events.ReadyEvent;

import java.util.*;

public class WhitelistCommands {

    public final static List<String> whitelistedCommands = new ArrayList<>();

    public static void setWhitelistedCommands(){
        whitelistedCommands.add("!help");
        whitelistedCommands.add("!verify");
        whitelistedCommands.add("");
    }

}
