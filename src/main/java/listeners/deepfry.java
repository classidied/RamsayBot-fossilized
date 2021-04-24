package listeners;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.Objects;

public class deepfry extends ListenerAdapter {
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event){
        String messageSent= event.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("~deepfry")){
            File file = new File("idiotsand.png");
            event.getChannel().sendFile(file).queue();
            return;
        }
    }
}
