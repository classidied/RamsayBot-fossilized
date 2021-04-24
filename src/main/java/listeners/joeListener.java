package listeners;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class joeListener extends ListenerAdapter {
    File dangerList= new File ("joe.csv");
    Scanner s = null;
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            s = new Scanner(dangerList);
            // reading insults into the arraylist
            while (s.hasNextLine()) {
                lines.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i=0; i<lines.size();i++) {
            if (event.getMessage().getContentRaw().toLowerCase().contains(lines.get(i))) {
                event.getMessage().delete().queue();
                event.getChannel().sendMessage("Watch out dude...").queue();
                return;
            }
        }
    }
}
