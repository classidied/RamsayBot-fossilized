import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Random;

import javax.annotation.Nonnull;

public class RecipeListener extends ListenerAdapter {
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event){
        // init file + scanner + random object
        File recipeList = new File ("recipe.csv");
        Scanner s;
        Random r = new Random();
        // creating arraylist to store all recipes + associated links
        ArrayList<String> recipes = new ArrayList<>();
        // try-catch to ensure file exists
        try {
            s = new Scanner(recipeList);
            // reading insults into the arraylist
            while (s.hasNext()) {
                recipes.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // checking message sent, splitting into string array
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        String[] message = new String[2];
        //  ensuring message array has 2 fields so we don't get a heckin indexoutofobounds exception
        if (messageSent.length == 1) {
            message[0] = messageSent[0];
            message[1] = "";
        } else {
            message = messageSent;
        }
        // case 1: with keyword
        if (message[0].equalsIgnoreCase("~recipe") && !(message[1].equals(""))) {
            // perform linear search to match keywords with recipes, store the matched recipes in an arraylist
            ArrayList<String> options = new ArrayList<>();
            for (int i = 0; i < recipes.size(); i++) {
                String checkInfo = recipes.get(i).toLowerCase();
                // checks if the recipes contain keywords
                if (checkInfo.contains(message[1])) {
                    options.add(recipes.get(i));
                }
            }
            // exception handling + sending recipes
            if (options.isEmpty()) {
                event.getChannel().sendMessage("It appears that I do not have a recipe for \"" + message[1] + "\".\n" +
                        "If you wish, you can try again using less keywords or specificity.").queue();
            } else if (options.size() == 1) {
                String[] info2 = options.get(0).split(",");
                event.getChannel().sendMessage("Here's a recipe that matched your input: " + info2[0] + ":\n" + info2[1] +
                        "\nIf you screw up making this, I will know.").queue();
            } else {
                // sending max of 3 recipes
                event.getChannel().sendMessage("Here are a few recipes that matched your input:\n").queue();
                for (int i = 0; i < options.size(); i++) {
                    String[] info2 = options.get(i).split(",");
                    event.getChannel().sendMessage(info2[0] + ": " + info2[1] + "\n").queue();
                }
                event.getChannel().sendMessage("\nIf you screw up making one of my recipes, I will know.").queue();
            }
            return;
        } // case 2: random w/o keyword
        else if (message[0].equalsIgnoreCase("~recipe")) {
            // randomly generating a number to choose an recipe
            int num = r.nextInt(recipes.size());
            String recipe = recipes.get(num);
            // splitting recipe string into the title and corresponding link
            String[] info = recipe.split(",");
            event.getChannel().sendMessage("Here's my recipe for " + info[0] + ":\n" + info[1] +
                    "\nIf you don't make this immediately I will have the IRS come for you and your family.").queue();
            return;
        }
    }
}
