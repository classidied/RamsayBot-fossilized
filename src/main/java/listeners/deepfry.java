package listeners;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.List;
import java.util.Objects;

public class deepfry extends ListenerAdapter {
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().startsWith("~deepfry")){
            List<Member> mentionedMembers = event.getMessage().getMentionedMembers();
            if (mentionedMembers.isEmpty()) {
                event.getChannel().sendMessage(createEmbed(event.getAuthor())).queue();
            }
            else {
                event.getChannel().sendMessage(createEmbed(mentionedMembers.get(0).getUser())).queue();
            }
        }
    }
    public MessageEmbed createEmbed(User user) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setImage(user.getAvatarUrl());
        return embedBuilder.build();
    }
}
