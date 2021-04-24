package listeners;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.Random;

public class bruhListener extends ListenerAdapter {

    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().toLowerCase().contains("~bruh")) {

            event.getChannel().sendFile(new File("bruh.jpg")).queue();
            return;
        }
    }
}
