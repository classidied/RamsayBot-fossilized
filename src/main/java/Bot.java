import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class Bot {
    public static JDABuilder builder;
    public static void main (String[] args) throws LoginException {
        String token= "ODM1MjQ1OTU2NTk2NjI5NTI0.YIMpag.882RAbOshwq8mAnNFzXO8QSn7jU";
        builder = JDABuilder.createDefault(token);

        builder.disableCache(CacheFlag.MEMBER_OVERRIDES,CacheFlag.VOICE_STATE);

        builder.setBulkDeleteSplittingEnabled(false);

        builder.setCompression(Compression.NONE);

        builder.setActivity(Activity.playing("With my feelings"));

        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        builder.build();

    }
}