package events;

import net.dv8tion.jda.api.EmbedBuilder;

import javax.xml.bind.Marshaller;
import java.util.Random;

public class joined extends Marshaller.Listener {
    String[] messages= {
            "Welcome to Hell's Kitchen, [member]!",
            "Did you bring the lamb sauce with you, [member]?"};
    public void onGuildMemberJoin (joined event){
        Random rand = new Random();
        int number = rand.nextInt(messages.length);
        EmbedBuilder join = new EmbedBuilder();
        //join.setDescription(messages[number].replaceAll("[member]",event.g.getAsMentioned()))
    }
}
