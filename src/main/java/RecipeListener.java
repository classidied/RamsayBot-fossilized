import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import javax.annotation.Nonnull;

public class RecipeListener extends ListenerAdapter {
    // init file + scanner
    File recipeList = new File ("recipes.csv");
    Scanner s = null;


    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event){
        // creating arraylist to store all recipes + associated links
        ArrayList<String> recipes = new ArrayList<>();
        // try-catch to ensure file exists
        try {
            s = new Scanner(recipeList);
            // reading insults into the arraylist
            while (s.hasNextLine()) {
                recipes.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // randomly generating a number to choose an recipe (function without keyword)
        Random r = new Random();
        int num = r.nextInt(recipes.size());
        String recipe = recipes.get(num);
        // checking message sent
        String messageSent= event.getMessage().getContentRaw();
        // case 1: no keyword, random recipe
        if(messageSent.equalsIgnoreCase("~recipe")){
            event.getChannel().sendMessage("If you don't make this immediately I will have the IRS come for you and your family "+recipe).queue();
            return;
        }
        // case 2: keyword(s) included
    }
}
