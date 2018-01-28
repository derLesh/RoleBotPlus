package main.java.de.lesh.rolebotplus;

import main.java.de.lesh.rolebotplus.utils.*;
import main.java.de.lesh.rolebotplus.commands.GuildEvent.*;
import main.java.de.lesh.rolebotplus.commands.MessageEvent.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.utils.JDALogger;
import org.slf4j.Logger;

public class Main {

    private static JDA jda;
    private static JDABuilder jdaB = new JDABuilder(AccountType.BOT);
    public static Logger jLog = JDALogger.getLog("RoleBotPlus");

    public static void main(String[] args) {
        jLog.info("Starting RoleBot+ ...");
        try {
            jda = jdaB.setToken(Token.getToken()).setGame(Game.listening("!verify // !help")).buildBlocking();
        } catch (Exception e) {
            jLog.warn("There was an error during launching - " + e);
        }
        jda.addEventListener(new verify());
        jda.addEventListener(new welcome());
        jda.addEventListener(new leave());
        jda.addEventListener(new Bot());
        jda.addEventListener(new ban());
        jda.addEventListener(new Help());

        jLog.info("Ready to use ... Have fun");
    }
}
