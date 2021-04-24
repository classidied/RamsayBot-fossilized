package listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;

public class helpListener extends ListenerAdapter {
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event){
        if (event.getMessage().getContentRaw().equalsIgnoreCase("~help")){
            EmbedBuilder help= new EmbedBuilder();
            help.setTitle("Ramsay Bot Info");
            help.setDescription("Hello, I'm Gordon Ramsay. My prefix is ~, and now I will always be with you. Figure out what typing these words do ;)) 'eat', 'lamb', 'sausage'");
            help.addField("~insult","I Insult you :)",false);
            help.addField("~encourage","I encourage you",false);
            help.addField("~bruh","A funny image of me",false);
            help.addField("~idiot <@member>","I Idiot-Sandwich your friend",false);
            help.addField("~alarm <@member>","I Awake your fellow members",false);
            help.addField("~recipe <keyword> (Keyword is optional)","I Send recipes from my website",false);
            help.setColor(Color.RED);
            event.getChannel().sendMessage(help.build()).queue();
            return;
        }
    }
}
