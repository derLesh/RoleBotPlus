package de.lesh.rolebotplus;

import de.lesh.rolebotplus.commands.GuildEvent.ban;
import de.lesh.rolebotplus.commands.GuildEvent.leave;
import de.lesh.rolebotplus.commands.GuildEvent.welcome;
import de.lesh.rolebotplus.commands.MessageEvent.Bot;
import de.lesh.rolebotplus.commands.MessageEvent.Help;
import de.lesh.rolebotplus.commands.MessageEvent.verify;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.utils.JDALogger;
import org.slf4j.Logger;

public class Main {

    public static Logger jLog = JDALogger.getLog("RoleBotPlus");
    private static JDA jda;
    private static JDABuilder jdaB = new JDABuilder(AccountType.BOT);

    public static void main(String[] args) {
        jLog.info("Starting RoleBot+ ...");
        try {
            jda = jdaB.setToken(Config.getToken())
                    .setGame(Game.listening("!verify // !help"))
                    .buildBlocking();
        } catch (Exception e) {
            jLog.error("Error during logging in", e);
            System.exit(1);
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
