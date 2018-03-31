package de.lesh.rolebotplus.commands.MessageEvent.AdminExecution;

import de.lesh.rolebotplus.Config;
import de.lesh.rolebotplus.Main;
import de.lesh.rolebotplus.utils.lib;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ReloadEvent extends ListenerAdapter{

    public void onMessageReceived(MessageReceivedEvent e){
        Message msg = e.getMessage();
        if(msg.getContentRaw().startsWith(lib.prefix + "reload") && e.getAuthor().getId().equals(Config.getAdminId())){
            //Main.setEventListeners();
            e.getChannel().sendMessage("Hi").queue();
        }
    }
}
