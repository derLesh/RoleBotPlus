package de.lesh.rolebotplus.commands.MessageEvent;

import de.lesh.rolebotplus.utils.lib;
import me.lesh.material.LightBlue;
import me.lesh.material.Red;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class PingEvent extends ListenerAdapter {

    String OS = "os.name";

    public void onMessageReceived(MessageReceivedEvent e){
        Message msg = e.getMessage();
        EmbedBuilder eB = new EmbedBuilder();
        if(msg.getContentRaw().startsWith(lib.prefix+"ping")){
            eB.setColor(LightBlue.lb500);
            eB.addField("Ready, set, go", "\uD83C\uDFD3 Pong: " + e.getJDA().getPing(), false);
            eB.setFooter("Running on " + System.getProperty(OS), null);
            e.getChannel().sendMessage(eB.build()).queue();
        }
    }
}
