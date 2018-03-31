package de.lesh.rolebotplus.commands.GuildEvent;

import de.lesh.rolebotplus.Main;
import me.lesh.material.Blue;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class WelcomeEvent extends ListenerAdapter {
    Role nonVerifiedBot;

    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
        EmbedBuilder eB = new EmbedBuilder();
        if (!e.getMember().getUser().isBot()) {
            eB.addField("Willkommen auf " + e.getGuild().getName(), e.getMember().getAsMention() + " (" + e.getMember().getUser().getName() + " #" + e.getMember().getUser().getDiscriminator() + ") hat den Server betreten", true);
            eB.addField("Introduction", "```Um alle Infos zu erhalten besuche #willkommen , für weiter Hilfe frage in #discussion nach und andere können dir helfen. Damit du alle Funktionen auf dem Server nutzen kannst, bestätige dich mit **!VerifyEvent**```", false);
            eB.setFooter(" - RoleBot+ - More infos: !help - Made by Lesh", e.getMember().getUser().getEffectiveAvatarUrl());
            eB.setColor(Blue.b400);
            Main.jLog.info("User " + e.getMember().getEffectiveName() + " joined the Guild (" + e.getGuild().getName() + ")");
            e.getGuild().getTextChannelById(316325706923507721L).sendMessage(eB.build()).complete();
            return;
        }
        if (e.getMember().getUser().isBot()) {
            eB.addField("Beep Beep Boop " + e.getGuild().getName(), e.getMember().getAsMention() + " (" + e.getMember().getUser().getName() + " #" + e.getMember().getUser().getDiscriminator() + ") hat den Server betreten", true);
            eB.addField("Introduction", "```Bevor der BotInviteEvent einsatzbereit ist muss der Inhaber des Bots bestätigt sein und der BotInviteEvent ansich muss nochmals durch einen Mod/Admin verifiziert werden```", false);
            eB.setFooter(" - RoleBot+ - More infos: !help - Made by Lesh", e.getMember().getUser().getEffectiveAvatarUrl());
            eB.setColor(Blue.b400);
            Main.jLog.info("BotInviteEvent " + e.getMember().getEffectiveName() + " joined the Guild (" + e.getGuild().getName() + ")");
            e.getGuild().getController().addSingleRoleToMember(e.getMember(), nonVerifiedBot.getJDA().getRoleById(402583061922971649L));
            e.getGuild().getTextChannelById(316325706923507721L).sendMessage(eB.build()).complete();
            return;
        }
    }
}
