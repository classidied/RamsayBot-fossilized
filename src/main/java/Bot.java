import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Bot {
    private static JDA jda;
    public static void main (String[] args) {
        System.out.println("helia do you see this");
        jda = (JDA) new JDABuilder(AccountType.BOT);

    }
}