package main.java.de.lesh.rolebotplus.commands.MessageEvent;

import main.java.de.lesh.rolebotplus.utils.lib;
import me.lesh.material.Yellow;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.requests.Route;

import java.util.List;

public class Support {

    public void onMessageReceived(MessageReceivedEvent e){
        EmbedBuilder eB = new EmbedBuilder();
        Message msg = e.getMessage();
        if (msg.getContentRaw().startsWith(lib.prefix + "support")){
            e.getAuthor().openPrivateChannel().queue(msgQ -> {
                eB.addField("Persönlicher Support", "```Du hast eine Frage zum Server, möchtests einen Bug melden oder hast Vorschläge? Dann sende sie in diesem Chat```", false);
                eB.addField("Wie geht der Support?", "```Damit du einen Mod oder Admin erreichst benutze den folgenden Command```", false);
                eB.addField("", "`!support start` -> Starte den Support \n`!support msg <nachricht>` -> Beschriebe hier deine Probleme \n`!support rep <id> <nachricht>` -> Antworte auf eine Nachricht von die dir gesendet wurde", false);
                eB.setColor(Yellow.y800);
                msgQ.sendMessage(eB.build());

                }
            );
        }
    }

    public void onPrivateMessageReceived(PrivateMessageReceivedEvent e){
        Message msg = e.getMessage();
        EmbedBuilder eB = new EmbedBuilder();
        Role mods = e.getJDA().getGuildById(316125040917872660L).getRoleById(324869706148216832L);
        Role admin = e.getJDA().getGuildById(316125040917872660L).getRoleById(316125448184791040L);
        List<Member> helpUser = e.getJDA().getGuildById(316125040917872660L).getMembersWithRoles(mods, admin);
        String userDisc;
        if (msg.getContentRaw().startsWith(lib.prefix + "support start")){
            userDisc = e.getAuthor().getDiscriminator();
        }
    }
}
