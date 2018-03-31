package de.lesh.rolebotplus.commands.MessageEvent.PrivateChannel;

import de.lesh.rolebotplus.utils.lib;
import me.lesh.material.Red;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ReportEvent extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e){
        Message msg = e.getMessage();
        EmbedBuilder eB = new EmbedBuilder();
        if(msg.getContentRaw().startsWith(lib.prefix+"report ")){
            String[] reportReason = msg.getContentRaw().split("\\s+",2);
            if(!reportReason[1].startsWith("@") || reportReason[1].isEmpty()){
                eB.addField("Fehler", "Es wurde kein User gefunden", false);
                eB.addField("Meintest du", "```!report <user> <reason>```", false);
                eB.setColor(Red.r400);
                e.getAuthor().openPrivateChannel().queue(sM -> sM.sendMessage(eB.build()));
                return;
            }
        }
    }

}
