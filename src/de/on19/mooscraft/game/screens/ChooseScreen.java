package de.on19.mooscraft.game.screens;

import de.on19.mooscraft.renderer.Screen;
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

    //constructor: choose Screen: for choose Situations like choosing a character or choosing a path
    public ChooseScreen() {
        super(); //constructor of the higher ranked class called and used
        this.options = new ArrayList<String>(); //initlaisation arrayList
        this.instruction = ""; //placeholder for following instruction text
    }
    //clears screen
    public void clear() {
        super.clear(); //method of Screen class is called
        options.clear(); //screen is cleared
        instruction = "";
    }

    //additional choice option e.g.: 2 characters to choose before --> add a third character to choose
    //ONE option
    public void addOption(String option) {
        this.options.add(option);
    }

    //multiple options are added via arrayList
    //MULTIPLE options
    public void addOptions(String[] options) {
        TextTools.append(this.options, options);
    }

    //output all options
    public List<String> getOptions() {
        return this.options;
    }

    //initialize instruction method
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    //formation of the options typed in by user
    public String[] getFormattedOptions() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //every letter as an element of an arrayList

        String[] formattedContent = new String[options.size()]; //new String array with placeholders for every option

        for (int i = 0; i < options.size(); i++) { //??
            // display number instead of letter when there are too many options
            //we got an array of options, for every option a automatically generated letter is positioned at the front
            String delimeter = (options.size() >= alphabet.length ? i : Character.toString(alphabet[i]).toUpperCase()) + ". ";
            // Character.toString() converts decimal charcode to String
            formattedContent[i] = delimeter + options.get(i); //options get: returns element at a specific position; arrayListmethod
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
