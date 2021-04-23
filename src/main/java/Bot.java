import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Bot {
    private static JDA jda;
    public static void main (String[] args) throws Exception{
        System.out.println("helia do you see this");
        jda = (JDA) new JDABuilder(AccountType.BOT)
                .setToken("ODM1MjQ1OTU2NTk2NjI5NTI0.YIMpag.882RAbOshwq8mAnNFzXO8QSn7jU")
                .build();

    }
}