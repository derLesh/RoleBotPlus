package de.lesh.rolebotplus.commands.MessageEvent;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import de.lesh.rolebotplus.utils.WhitelistCommands;

public class DeleteEvent extends ListenerAdapter{

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if(e.getGuild().getTextChannelById(316126394629357568L).hasLatestMessage()){
            //if(e.getMessage().getContentRaw().contains(WhitelistCommands.whitelistedCommands.contains(e.getMessage().getContentRaw()))){

            //}
        }
    }
}
