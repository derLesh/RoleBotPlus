package de.lesh.rolebotplus.utils;

import net.dv8tion.jda.core.events.ReadyEvent;

import java.util.*;

public class WhitelistCommands {

    public static List<String> whitelistedCommands = new ArrayList<>();

    public static void setWhitelistedCommands(){
        whitelistedCommands.add(lib.prefix+"help");
        whitelistedCommands.add(lib.prefix+"verify");
        whitelistedCommands.add(lib.prefix+"reload");
        whitelistedCommands.add(lib.prefix+"support");
        whitelistedCommands.add(lib.prefix+"user");
        whitelistedCommands.add(lib.prefix+"changelog");
        whitelistedCommands.add(lib.prefix+"-");
        whitelistedCommands.add(lib.prefix+"-");
        whitelistedCommands.add(lib.prefix+"report");

    }
}
