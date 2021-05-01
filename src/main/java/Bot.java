import events.joined;
import listeners.helpListener;
import listeners.imageListener;
import listeners.joeListener;
import listeners.textListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class Bot {
    public static JDABuilder builder;
    public static void main (String[] args) throws LoginException {
        String token= "redacted before security sam or whoever comes after me again";
        builder = JDABuilder.createDefault(token);

        builder.disableCache(CacheFlag.MEMBER_OVERRIDES,CacheFlag.VOICE_STATE);

        builder.setBulkDeleteSplittingEnabled(false);

        builder.setCompression(Compression.NONE);
        // activity status
        builder.setActivity(Activity.playing("~help"));

        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);

        registerListener();
        builder.build();
    }

    /**
     * method to register functions under RamsayBot
     */
    public static void registerListener(){
        builder.addEventListeners((new textListener()));
        builder.addEventListeners((new RecipeListener()));
        builder.addEventListeners((new joined()));
        builder.addEventListeners((new located()));
        builder.addEventListeners((new imageListener()));
        builder.addEventListeners((new joeListener()));
        builder.addEventListeners((new helpListener()));
    }
}
