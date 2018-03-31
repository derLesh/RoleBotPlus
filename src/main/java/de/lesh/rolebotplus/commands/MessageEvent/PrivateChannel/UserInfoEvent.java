package de.lesh.rolebotplus.commands.MessageEvent.PrivateChannel;

import de.lesh.rolebotplus.utils.lib;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.time.format.DateTimeFormatter;

public class UserInfoEvent extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e){
        Message msg = e.getMessage();
        User uA = e.getAuthor();
        Guild g = e.getGuild();
        EmbedBuilder eB = new EmbedBuilder();
        if(msg.getContentRaw().startsWith(lib.prefix + "user")){
            String[] USERNAME = e.getMessage().getContentRaw().split("\\s+",2);
                eB.setThumbnail(uA.getEffectiveAvatarUrl());
                eB.addField("Discord Name", uA.getName(), true)
                    .addField("Server Nickname", uA.getAsMention(), true)
                    .addField("Discriminator", uA.getDiscriminator(), true)
                    .addField("Discord ID", ""+uA.getIdLong(), true)
                    .addField("Creation Time", uA.getCreationTime().format(DateTimeFormatter.ofPattern("hh:mm.ss a - dd.MM.yyyy")), true)
                    .addField("Join Time", g.getMember(uA).getJoinDate().format(DateTimeFormatter.ofPattern("hh:mm.ss a - dd.MM.yyyy")), true)
                    .addField("Roles", "Current Roles: ["+g.getMember(uA).getRoles().size()+"]", false);
                eB.addField("Verified", ""+uA.getJDA().getGuildById(e.getGuild().getId()).getMember(uA).getRoles().contains(e.getGuild().getRolesByName("verified", true)), true);
            e.getAuthor().openPrivateChannel().queue(sM -> sM.sendMessage(eB.build()).queue());
        }
    }
}
