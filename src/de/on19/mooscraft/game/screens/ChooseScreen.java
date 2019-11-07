package de.on19.mooscraft.game.screens;

import de.on19.mooscraft.utils.TextTools;

import java.util.ArrayList; //where can I find the Arraylist, Array, List
import java.util.Arrays;
import java.util.List;
/**
 * three different screen classes since every one got different structure
 * ChooseScreen: with choice options
 * ScoreboardScreen: only displays
 * Splashscreen: displays in the beginning
 */
    //All screens exist of two parts: instructions and options
    //class screen --> file renderer
public class ChooseScreen extends Screen {
    //Initialisation
    public List<String> options;
    public String instruction;

    //choose Screen: for choose Situations like choosing a character or choosing a path
    public ChooseScreen() {
        super(); //?
        this.options = new ArrayList<String>(); //why do we make a list above, if we make a new array list here? Difference list and arraylist
        this.instruction = ""; //placeholder
    }
    //clears screen
    public void clear() {
        super.clear(); //where is method clear?
        options.clear();
        instruction = "";
    }

    //additional choice option e.g.: 2 characters to choose before --> add a third character to choose
    public void addOption(String option) {
        this.options.add(option);
    }

    //new option is visualized
    public void addOptions(String[] options) {
        TextTools.append(this.options, options);
    }

    public List<String> getOptions() {
        return this.options;
    } //why return again?

    //initialize instruction method
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    //formation of the options typed in by user
    public String[] getFormattedOptions() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //all characters possible

        String[] formattedContent = new String[options.size()]; //??

        for (int i = 0; i < options.size(); i++) { //??
            // display number instead of letter when there are too many options
            // Character.toString() converts decimal charcode to String

            String delimeter = (options.size() >= alphabet.length ? i : Character.toString(alphabet[i]).toUpperCase()) + ". ";

            formattedContent[i] = delimeter + options.get(i); //??
        }
        return formattedContent;
    }

    @Override //??
    public String[] getContent() { //what does this method do in general?
        // Arrays.asList() only returns a list with fixed size, so we need to pass it into a new list: why??
        List<String> content = new ArrayList<String>(Arrays.asList(super.getContent())); //why super??

        TextTools.append(content, TextTools.emptyLines(1));

        // get nicely formatted options from above
        TextTools.append(content, getFormattedOptions());

        TextTools.append(content, TextTools.emptyLines(1));

        content.add(this.instruction);

        return content.toArray(new String[0]);
    }
}
