package listeners;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class textListener extends ListenerAdapter {
    File file;
    Scanner s = null;
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event){
        String messageSent= event.getMessage().getContentRaw();
        Random r = new Random();
        ArrayList<String> listOfPhrases= new ArrayList<>();
        /*
        insult command. Sends a famous Gordon Ramsay insult to the channel that it was mentioned in
         */
        if(messageSent.equalsIgnoreCase("~insult")){
            file= new File ("insults.csv");
            // try-catch to ensure file exists
            try {
                s = new Scanner(file);
                // reading insults into the arraylist
                while (s.hasNextLine()) {
                    listOfPhrases.add(s.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            int num = r.nextInt(listOfPhrases.size());
            String insult = listOfPhrases.get(num);//send a random insult
            event.getChannel().sendMessage(insult).queue();
            return;
        }
        /*
        encourage command, because everyone needs to hear some encouraging words from the chef himself :)
         */
        else if(messageSent.equalsIgnoreCase("~encourage")){
            file= new File ("encouragements.csv");
            try {
                s = new Scanner(file);
                // reading encouragements into the arraylist
                while (s.hasNextLine()) {
                    listOfPhrases.add(s.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int num = r.nextInt(listOfPhrases.size());
            String encourage = listOfPhrases.get(num);//send a random encouragement
            event.getChannel().sendMessage(encourage).queue();
            return;
        }
    }
}
