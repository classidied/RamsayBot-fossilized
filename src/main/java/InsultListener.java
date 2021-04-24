import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class InsultListener extends ListenerAdapter {
    File insultList= new File ("insult.csv");
    Scanner s = null;
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event){
        String insult = "";
        try {
            s = new Scanner (insultList);
            // creating arraylist to store all insults
            ArrayList<String> insults = new ArrayList<>();
            while (s.hasNextLine()) {
                insults.add(s.nextLine());
            }
            // randomly generating a number to choose an insult
            Random r = new Random();
            int num = r.nextInt(insults.size());
            insult = insults.get(num);

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
