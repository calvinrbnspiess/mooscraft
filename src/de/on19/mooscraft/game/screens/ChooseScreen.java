package de.on19.mooscraft.game.screens;

import de.on19.mooscraft.game.interaction.actions.GameAction;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChooseScreen extends Screen {

    public List<String> options;
    public String instruction;

    public ChooseScreen() {
        super();
        this.options = new ArrayList<String>();
        this.instruction = "";
    }

    public void clear() {
        super.clear();
        options.clear();
        instruction = "";
    }

    public void addOption(String option) {
        this.options.add(option);
    }

    public void addOptions(String[] options) {
        StringTools.append(this.options, options);
    }

    public List<String> getOptions() {
        return this.options;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    // A. ffff
    // B. ggf
    // C. fgg
    public String[] getFormattedOptions() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        String[] formattedContent = new String[options.size()];

        for (int i = 0; i < options.size(); i++) {
            // display number instead of letter when there are too many options
            // Character.toString() converts decimal charcode to String

            String delimeter = (options.size() >= alphabet.length ? i : Character.toString(alphabet[i]).toUpperCase()) + ". ";

            formattedContent[i] = delimeter + options.get(i);
        }
        return formattedContent;
    }

    @Override
    public String[] getContent() {
        // Arrays.asList() only returns a list with fixed size, so we need to pass it into a new list
        List<String> content = new ArrayList<String>(Arrays.asList(super.getContent()));

        StringTools.append(content, StringTools.emptyLines(1));

        // get nicely formatted options from above
        StringTools.append(content, getFormattedOptions());

        StringTools.append(content, StringTools.emptyLines(1));

        content.add(this.instruction);

        return content.toArray(new String[0]);
    }

}
