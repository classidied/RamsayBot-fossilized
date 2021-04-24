package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.xml.bind.Marshaller;
import java.util.Random;

public class joined extends ListenerAdapter {
    String[] messages = {
            "Welcome to Hell's Kitchen, [member]!",
            "Did you bring the lamb sauce with you, [member]?",
            "[member], I'll be your today's chef!",
            "You can't microwave a salad, [member]!",
            "Don't burn the ice cream, [member]!",
            "[member], you are the idiot to my sandwich <3"};
    public void onGuildMemberJoin (GuildMemberJoinEvent event){
        Random rand = new Random();
        int number = rand.nextInt(messages.length);
        EmbedBuilder join = new EmbedBuilder();

        join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));
        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
    }
}
