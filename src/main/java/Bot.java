import events.joined;
import listeners.SandwichListener;
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
        // activity status
        builder.setActivity(Activity.playing("With my feelings"));

        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);

        registerListener();
        builder.build();
    }

    /**
     * method to register functions under RamsayBot
     */
    public static void registerListener(){
        builder.addEventListeners((new InsultListener()));
        builder.addEventListeners((new EncourageListener()));
        builder.addEventListeners((new RecipeListener()));
        builder.addEventListeners((new SandwichListener()));
        builder.addEventListeners((new joined()));
    }
}