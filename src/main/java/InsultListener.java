import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class InsultListener extends ListenerAdapter {
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event){
        String messageSent= event.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("~insult")){
            event.getChannel().sendMessage("get out, you useless sack of yankee danky doodle shite!").queue();
            return;
        }
    }
}
