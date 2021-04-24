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
        String[] info = recipe.split(","); // splitting recipe string into the title and corresponding link

        // checking message sent, splitting into string array
        String messageSent = event.getMessage().getContentRaw();
        String[] command = messageSent.split(" ", 1); // delimit the command and keyword(s) by first space
        // testing
        event.getChannel().sendMessage("message sent split into string array:" + command[0] + ", " + command[1]);
        // case 1: no keyword, random recipe
        if(messageSent.equalsIgnoreCase("~recipe")){
            event.getChannel().sendMessage("Here's my recipe for " + info[0] + ":\n" + info[1] +
                    "\nIf you don't make this immediately I will have the IRS come for you and your family.").queue();
            return;
        } // case 2: with keyword(s), will output (at most) 3 random recipes from a matched list
        else if (command[0].equalsIgnoreCase("~recipe") && !(command[1].equals(null))) {
            // perform linear search to match keywords with recipes, store the matched recipes in an arraylist
            ArrayList<String> options = new ArrayList<>();
            for (int i = 0; i < recipes.size(); i++) {
                String[] checkInfo = recipe.split(",");
                // checks if the recipes (through titles) contain keywords
                if (checkInfo[0].toLowerCase().contains(command[1])) {
                    options.add(recipes.get(i));
                }
            }
            // exception handling + sending recipes
            if (options.size() == 0) {
                event.getChannel().sendMessage("It appears that I do not have a recipe for \"" + command[1] + "\".\n" +
                        "If you wish, you can try again using less keywords or specificity.");
            } else if (options.size() == 1) {
                String[] info2 = options.get(0).split(",");
                event.getChannel().sendMessage("Here's a recipe that matched your input: " + info2[0] + ":\n" + info2[1] +
                        "\nIf you screw up making this, I will know.").queue();
            } else {
                // sending message on a loop
                for (int i = 0; i < options.size(); i++) {
                    String[] info2 = options.get(i).split(",");
                    event.getChannel().sendMessage("Here are a few recipes that matched your input: " + info2[0] + ":\n" + info2[1] +
                            "\nIf you screw up making one of my recipes, I will know.").queue();
                }
            }


            event.getChannel().sendMessage("Here are a few recipes that matched your input:" + info[0] + ":\n" + info[1] +
                    "\nIf you screw up making one of my recipes, I will know.").queue();
            return;
        }
    }
}
