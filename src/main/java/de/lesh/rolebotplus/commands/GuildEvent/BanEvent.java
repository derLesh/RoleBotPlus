package de.lesh.rolebotplus.commands.GuildEvent;

import me.lesh.material.Red;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.audit.ActionType;
import net.dv8tion.jda.core.audit.AuditLogEntry;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Guild.Ban;
import net.dv8tion.jda.core.events.guild.GuildBanEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.requests.RestAction;

import java.util.List;

public class BanEvent extends ListenerAdapter {

    public void onGuildBan(GuildBanEvent e) {
        EmbedBuilder eB = new EmbedBuilder();
        eB.addField("Gone forever - RIP " + e.getUser(), e.getUser().getName() + "#" + e.getUser().getDiscriminator() + "- Created: " + e.getUser().getCreationTime(), false);
        if (e.getGuild().getSelfMember().hasPermission(Permission.VIEW_AUDIT_LOGS)) {
            List<AuditLogEntry> logEntries = e.getGuild().getAuditLogs()
                    .type(ActionType.BAN)
                    .user(e.getUser().getId())
                    .limit(1)
                    .complete();
            if (logEntries.size() > 0) {
                AuditLogEntry entry = logEntries.get(0);
                eB.addField("Ban reason", entry.getReason(),false);
            }
        }
        eB.setColor(Red.r700);
        e.getGuild().getTextChannelById(316325706923507721L).sendMessage(eB.build()).queue();
    }

}
