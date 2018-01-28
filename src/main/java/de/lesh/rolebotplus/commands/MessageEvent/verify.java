package de.lesh.rolebotplus.commands.MessageEvent;

import de.lesh.rolebotplus.Main;
import de.lesh.rolebotplus.utils.lib;
import me.lesh.material.Green;
import me.lesh.material.Red;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

public class verify extends ListenerAdapter {

    Role vRole;

    public void onMessageReceived(MessageReceivedEvent e) {
        vRole = e.getJDA().getRoleById(401772846050967572L);
        EmbedBuilder eB = new EmbedBuilder();
        Message msg = e.getMessage();
        if (msg.getContentRaw().startsWith(lib.prefix + "verify") && !msg.getMember().getRoles().contains(vRole)) {
            e.getGuild().getController().addSingleRoleToMember(msg.getMember(), vRole).queue();
            eB.addField("Vielen Dank fürs verifizieren", msg.getMember().getEffectiveName() + " hat sich für mehr Commands verifiziert", true);
            eB.setColor(Green.g500);
            eB.setFooter("RoleBot+ / More infos: !help / Made by Lesh", null);
            Main.jLog.info("Added VERIFIED Role to " + e.getMember().getEffectiveName());
            e.getMessage().delete().queueAfter(1, TimeUnit.MILLISECONDS);
            e.getChannel().sendMessage(eB.build()).queue(msge -> msge.delete().queueAfter(20, TimeUnit.SECONDS));
        } else if (msg.getContentRaw().startsWith(lib.prefix + "verify") && msg.getMember().getRoles().contains(vRole)) {
            eB.addField("Du bist schon verifiziert", "Es ist dir leider nicht möglich deine Verifizierung aufzuheben. Frage einen Mod/Admin für mehr Infos", true);
            eB.setColor(Red.r500);
            eB.setFooter("RoleBot+ - More infos: !help - Made by Lesh", null);
            Main.jLog.info("Blocked VERIFIED Role to " + e.getMember().getEffectiveName());
            e.getMessage().delete().queueAfter(1, TimeUnit.MILLISECONDS);
            e.getChannel().sendMessage(eB.build()).queue(msge -> msge.delete().queueAfter(20, TimeUnit.SECONDS));
        }
    }
}
