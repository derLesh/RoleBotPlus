package de.lesh.rolebotplus;

import de.lesh.rolebotplus.commands.GuildEvent.BanEvent;
import de.lesh.rolebotplus.commands.GuildEvent.LeaveEvent;
import de.lesh.rolebotplus.commands.GuildEvent.WelcomeEvent;
import de.lesh.rolebotplus.commands.MessageEvent.BotInviteEvent;
import de.lesh.rolebotplus.commands.MessageEvent.HelpEvent;
import de.lesh.rolebotplus.commands.MessageEvent.VerifyEvent;
import de.lesh.rolebotplus.utils.WhitelistCommands;
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
        WhitelistCommands.setWhitelistedCommands();
        jda.addEventListener(new VerifyEvent());
        jda.addEventListener(new WelcomeEvent());
        jda.addEventListener(new LeaveEvent());
        jda.addEventListener(new BotInviteEvent());
        jda.addEventListener(new BanEvent());
        jda.addEventListener(new HelpEvent());

        jLog.info("Ready to use ... Have fun");
    }
}
