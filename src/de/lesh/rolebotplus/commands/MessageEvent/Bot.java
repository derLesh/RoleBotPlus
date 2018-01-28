package de.lesh.rolebotplus.commands.MessageEvent;

import me.lesh.material.Green;
import me.lesh.material.Red;
import me.lesh.material.Yellow;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Bot extends ListenerAdapter {

    private String currentTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

    public void onPrivateMessageReceived(PrivateMessageReceivedEvent e) {
        Role owner = e.getJDA().getRoleById(316125448184791040L);
        EmbedBuilder eB = new EmbedBuilder();
        String inviteLink;
        if (e.getMessage().getContentRaw().contains("https://discordapp.com/api/oauth2/authorize?client_id=")) {
            inviteLink = e.getMessage().getContentRaw();
            eB.addField("Vielen Dank für deinen Bot", "Dein Bot Invite wird nun zu einem Mod/Admin geschickt. Diese überprüfen deinen Status und den deines Bots. Bitte gedulde dich ...", true);
            eB.setColor(Green.g700);
            e.getChannel().sendMessage(eB.build()).complete();
            eB.clear();
            eB.addField("\uD83D\uDEE0  Bot Invite Link", "```" + inviteLink + "```", false);
            eB.addField("\uD83D\uDC7B  User", e.getAuthor().getName() + " #" + e.getAuthor().getDiscriminator(), true);
            eB.addField("⏰  Timestamp", currentTime, true);
            eB.setColor(Yellow.y700);
            e.getJDA().getGuildById(316125040917872660L).getOwner().getUser().openPrivateChannel().queue(userMSG -> userMSG.sendMessage(eB.build()).queue());
        }
    }

    public void onMessageReceived(MessageReceivedEvent event) {
        EmbedBuilder eB = new EmbedBuilder();
        if (event.getMessage().getContentRaw().contains("https://discordapp.com/api/oauth2/authorize?client_id=") && event.getChannelType().isGuild()) {
            event.getMessage().delete().queue();
            eB.addField("\uD83D\uDD38 Information", "```Bitte sende den Invite Link erneut in **diesen** Chat, damit dieser an einen Owner gesendet werden kann```", false);
            eB.addField("\uD83D\uDD38 Public Bot", "```Damit der Bot hinzugefügt werden kann muss die Einstellung **Public Bot** aktiviert sein```", true);
            eB.addField("\uD83D\uDD38 Permissions=0", "```Bots nicht mit Permissions schicken. Lass sie unverändert und er wird angepasst auf den Server gestellt```", true);
            eB.setColor(Red.r300);
            event.getAuthor().openPrivateChannel().queue(msg -> msg.sendMessage(eB.build()).queue());
        }
    }
}
