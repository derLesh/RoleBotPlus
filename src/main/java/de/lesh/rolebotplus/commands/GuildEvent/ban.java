package main.java.de.lesh.rolebotplus.commands.GuildEvent;

import me.lesh.material.Red;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Guild.Ban;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.guild.GuildBanEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.requests.RestAction;

import java.util.List;

public class ban extends ListenerAdapter {
    Guild.Ban ban;

    public void onGuildBan(GuildBanEvent e) {

        EmbedBuilder eB = new EmbedBuilder();
        RestAction<List<Ban>> banList = e.getGuild().getBanList();
        eB.addField("Gone forever - RIP " + e.getUser(), e.getUser().getName() + "#" + e.getUser().getDiscriminator() + "- Created: " + e.getUser().getCreationTime(), false);
        eB.addField("Ban reason", "", false);
        eB.setColor(Red.r700);
        e.getGuild().getTextChannelById(316325706923507721L).sendMessage(eB.build()).queue();
    }

}
