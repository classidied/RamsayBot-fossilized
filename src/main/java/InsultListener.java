import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InsultListener extends ListenerAdapter {
    File insultList= new File ("insult.csv");
    Scanner s= null;
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event){
        String insult="You donkey";
        try {
            s = new Scanner (insultList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String messageSent= event.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("~insult")){
            event.getChannel().sendMessage(insult).queue();
            return;
        }
    }
}
