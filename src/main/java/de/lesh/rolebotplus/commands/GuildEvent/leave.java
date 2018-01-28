package main.java.de.lesh.rolebotplus.commands.GuildEvent;

import main.java.de.lesh.rolebotplus.Main;
import me.lesh.material.LightBlue;
import me.lesh.material.Red;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class leave extends ListenerAdapter {
    public void onGuildMemberLeave(GuildMemberLeaveEvent e) {
        EmbedBuilder eB = new EmbedBuilder();
        long userID = e.getUser().getIdLong();
        if (!e.getMember().getUser().isBot()) {
            eB.addField("Man sieht sich wieder auf " + e.getGuild().getName(), e.getMember().getAsMention() + " (" + e.getMember().getUser().getName() + " #" + e.getMember().getUser().getDiscriminator() + ") hat den Server verlassen", true);
            eB.setColor(Red.r900);
            Main.jLog.info("User " + e.getMember().getEffectiveName() + " left the Guild (" + e.getGuild().getName() + ")");
            e.getGuild().getTextChannelById(316325706923507721L).sendMessage(eB.build()).queue();
            eB.clear();
            eB.addField("Auf wiedersehen :(", "Schade, wir hätten dich gerne bei uns gehalten, jedoch hast du dich gegen uns entschieden. Sei es unzufriedenheit oder einfach nur nicht das richtige. Ich hoffe jedoch, dass du weiterhin ein tolle Zeit hast", false);
            eB.addField("Du hast es dir anders überlegt?", "Wir sind immer offen für dich. Keine Tür ist verschlossen und damit das auch so bleibt, hinterlasse ich dir einen Invite Code zu unserem Server: <https://discord.gg/889PF8Q>", false);
            eB.setColor(LightBlue.lb300);
            e.getUser().openPrivateChannel().queue((channel) -> channel.sendMessage(eB.build()).complete());
        }
    }
}
