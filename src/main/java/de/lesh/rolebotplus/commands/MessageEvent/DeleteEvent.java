package de.lesh.rolebotplus.commands.MessageEvent;

import de.lesh.rolebotplus.Main;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import de.lesh.rolebotplus.utils.WhitelistCommands;

import java.time.format.DateTimeFormatter;

public class DeleteEvent extends ListenerAdapter{

    public void onMessageReceived(MessageReceivedEvent e) {
        if(e.getGuild().getTextChannelById(316126394629357568L).hasLatestMessage()){
            boolean COMMAND_AVAIBLE = true;
            while(COMMAND_AVAIBLE) {
                if (WhitelistCommands.whitelistedCommands.contains(e.getMessage().getContentRaw()) || e.getAuthor().isBot()) {
                    return;
                }
                else {
                    COMMAND_AVAIBLE = false;
                    Main.jLog.info("Deleted non whitelisted word - From: " + e.getAuthor() + " - Time: " + e.getMessage().getCreationTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy / hh:mm")) + " Message: " + e.getMessage().getContentRaw());
                    e.getMessage().delete().queue();
                }
            }
        }
    }
}
