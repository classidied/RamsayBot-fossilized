package listeners;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.List;
import java.util.Random;

public class imageListener extends ListenerAdapter {

    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().toLowerCase().contains("~bruh")) {
            event.getMessage().delete().queue();
            event.getChannel().sendFile(new File("bruh.jpg")).queue();
            return;
        }
        else if (event.getMessage().getContentRaw().toLowerCase().contains(" eat ") || event.getMessage().getContentRaw().equalsIgnoreCase("eat")){
            event.getChannel().sendFile(new File("lick.PNG")).queue();
            return;
        }
        else if (event.getMessage().getContentRaw().toLowerCase().contains("~alarm")){//keyword
            List<Member> mentionedMember = event.getMessage().getMentionedMembers();//get member id to mention them
            String id;
            if (mentionedMember.isEmpty()) {
                id = event.getAuthor().getId();
            }
            else {
                id = mentionedMember.get(0).getId();
            }
            event.getChannel().sendMessage("<@"+id+">").addFile(new File("wake.gif")).queue();//send file and mention
            return;
        }
        else if (event.getMessage().getContentRaw().toLowerCase().contains("~idiot")){//keyword
            List<Member> mentionedMember = event.getMessage().getMentionedMembers();//get member id to mention them
            String id;
            if (mentionedMember.isEmpty()) {
                id = event.getAuthor().getId();
            }
            else {
                id = mentionedMember.get(0).getId();
            }
            event.getChannel().sendMessage("<@"+id+">").addFile(new File("idiotsandwich.png")).queue();//send file and mention
            return;
        }
    }
}
