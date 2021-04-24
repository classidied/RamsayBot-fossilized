package listeners;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.annotation.Nonnull;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SandwichListener extends ListenerAdapter {
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().startsWith("~idiot")){
            List<Member> mentionedMembers = event.getMessage().getMentionedMembers();
            if (mentionedMembers.isEmpty()) {
                event.getChannel().sendMessage(createEmbed(event.getAuthor())).queue();
                event.getChannel().sendMessage(".").addFile(new File("sandwich.png")).queue();
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
