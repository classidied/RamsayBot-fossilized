import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class EncourageListener extends ListenerAdapter {
    // init file + scanner
    File encourageList= new File ("encouragements.csv");
    Scanner s = null;

    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event){
        // creating arraylist to store all insults
        ArrayList<String> encouragements = new ArrayList<>();
        // try-catch to ensure file exists
        try {
            s = new Scanner(encourageList);
            // reading insults into the arraylist
            while (s.hasNextLine()) {
                encouragements.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // randomly generating a number to choose an insult
        Random r = new Random();
        int num = r.nextInt(encouragements.size());
        String encourage = encouragements.get(num);
        // checking sent messages
        String messageSent= event.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("~encourage")){
            event.getChannel().sendMessage(encourage).queue();
            return;
        }
    }
}
