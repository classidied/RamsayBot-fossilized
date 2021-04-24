import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.io.File;

public class located extends ListenerAdapter {
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event) {
        //if a phrase contains the letters "lamb" in order, sends a lamb sauce meme
        if (event.getMessage().getContentRaw().toLowerCase().contains("lamb")){
            event.getChannel().sendFile(new File("located.jpg")).queue();
            return;
        }
        //if a phrase contains the letters "sausage" in order, sends a sosig meme
        else if ((event.getMessage().getContentRaw().toLowerCase().contains("sausage"))){
            event.getChannel().sendFile(new File("sosig.jpg")).queue();
            return;
        }
    }
}
