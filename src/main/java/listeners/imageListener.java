package listeners;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.List;
import java.util.Random;

public class imageListener extends ListenerAdapter {
    /*
    All of the functions that are related to images and displaying images are bundled here
     */
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event) {
        /*
        Send a bruh-worthy picture of Ramsay when the function is sent
         */
        if (event.getMessage().getContentRaw().toLowerCase().contains("~bruh")) {
            event.getMessage().delete().queue();
            event.getChannel().sendFile(new File("bruh.jpg")).queue();
            return;
        }
        /*
        If the word "eat" is mentioned in the chat, send a picture of ramsay licking a plate :)
         */
        else if (event.getMessage().getContentRaw().toLowerCase().contains(" eat ") || event.getMessage().getContentRaw().equalsIgnoreCase("eat")){
            event.getChannel().sendFile(new File("lick.PNG")).queue();
            return;
        }
        /*
        If the message contains the key word alarm with or without a mentioned member, send a gif of ramsay saying wake up and ping
        the user
         */
        else if (event.getMessage().getContentRaw().toLowerCase().contains("~alarm")){//keyword
            List<Member> mentionedMember = event.getMessage().getMentionedMembers();//get member id to mention them
            String id;
            if (mentionedMember.isEmpty()) {
                id = event.getAuthor().getId();//change id accordingly
            }
            else {
                id = mentionedMember.get(0).getId();//change id accordingly
            }
            event.getChannel().sendMessage("<@"+id+">").addFile(new File("wake.gif")).queue();//send file and mention
            return;
        }
        /*
        Send an idiot sandwich meme for a mentioned user
         */
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
