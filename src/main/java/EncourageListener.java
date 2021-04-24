import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class EncourageListener extends ListenerAdapter {
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event){
        String messageSent= event.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("~encourage")){
            event.getChannel().sendMessage("I believe in you!").queue();
            return;
        }
    }
}
