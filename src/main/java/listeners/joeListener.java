package listeners;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.annotation.Nonnull;

public class joeListener extends ListenerAdapter {
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().toLowerCase().contains("who's joe?")||event.getMessage().getContentRaw().toLowerCase().contains("whos joe?")) {
            event.getMessage().delete().queue();
            event.getChannel().sendMessage("Watch out dude...").queue();
            return;
        }
    }
}
