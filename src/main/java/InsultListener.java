import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InsultListener extends ListenerAdapter {
    // reading in insults from file

    public static void main (String[] args) throws FileNotFoundException {
        File insultList = new File ("insults.csv");
        Scanner s = new Scanner (insultList);
        String delim = ",";

        // reading insults into arraylist
        ArrayList<Comparable> insults = new ArrayList<>();
        while (s.hasNextLine()) {
            insults.add(s.nextLine());
        }
        System.out.println(insults);
    }

    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event){
        String insult="";
        String messageSent= event.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("~insult")){
            event.getChannel().sendMessage(insult).queue();
            return;
        }
    }

}
