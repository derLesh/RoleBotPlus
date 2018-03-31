package de.lesh.rolebotplus;

import de.lesh.rolebotplus.commands.GuildEvent.BanEvent;
import de.lesh.rolebotplus.commands.GuildEvent.LeaveEvent;
import de.lesh.rolebotplus.commands.GuildEvent.WelcomeEvent;
import de.lesh.rolebotplus.commands.MessageEvent.HelpEvent;
import de.lesh.rolebotplus.commands.MessageEvent.PingEvent;
import de.lesh.rolebotplus.commands.MessageEvent.PrivateChannel.BotInviteEvent;
import de.lesh.rolebotplus.commands.MessageEvent.PrivateChannel.UserInfoEvent;
import de.lesh.rolebotplus.commands.MessageEvent.VerifyEvent;
import de.lesh.rolebotplus.utils.WhitelistCommands;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.utils.JDALogger;
import org.slf4j.Logger;

import java.util.logging.FileHandler;

public class Main {

    public static Logger jLog = JDALogger.getLog("RoleBotPlus");
    private static JDA jda;
    private static JDABuilder jdaB = new JDABuilder(AccountType.BOT);
    static FileHandler fileH;

    public static void main(String[] args) {
        /*
        try {
            fileH = new FileHandler("RoleBotPlus_Log-" + DateFormat.getDateInstance() + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        jLog.info("Starting RoleBot+ ...");
        try {
            jda = jdaB.setToken(Config.getToken())
                    .setGame(Game.listening("!verify / !help"))
                    .buildBlocking();
        } catch (Exception e) {
            jLog.error("Error during logging in", e);
            System.exit(1);
        }
        WhitelistCommands.setWhitelistedCommands();
        setEventListeners();


        jLog.info("Ready to use ... Have fun");
    }

    public static void setEventListeners(){
        jda.addEventListener(new VerifyEvent());
        jda.addEventListener(new WelcomeEvent());
        jda.addEventListener(new LeaveEvent());
        jda.addEventListener(new BotInviteEvent());
        jda.addEventListener(new BanEvent());
        jda.addEventListener(new HelpEvent());
        jda.addEventListener(new UserInfoEvent());
        jda.addEventListener(new PingEvent());
        //jda.addEventListener(new DeleteEvent());
        //jda.addEventListener(new ReloadEvent());
    }


}
