import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
public class RecipeListener extends ListenerAdapter {
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event){
        String messageSent= event.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("~recipe")){
            event.getChannel().sendMessage("Here's some good recipes for l a m b "+"https://www.gordonramsay.com/gr/recipes/lambshoulderwithspringvegetables/").queue();
            return;
        }
    }
}
