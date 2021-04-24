import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.Random;

public class located extends ListenerAdapter {
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().toLowerCase().contains("lamb")){
            event.getChannel().sendFile(new File("located.jpg")).queue();
            return;
        }
        else if ((event.getMessage().getContentRaw().toLowerCase().contains("sausage"))||(event.getMessage().getContentRaw().toLowerCase().contains("breakfast"))){
            event.getChannel().sendFile(new File("sosig.jpg")).queue();
            return;
        }
    }
}
