package de.on19.mooscraft.renderer;

import de.on19.mooscraft.utils.TextTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Screen {

    private List<String> lines;
    private List<String> debugInformationLines; //what is meant by this?

    public Screen() {
        this.lines = new ArrayList<String>(); //why now an arraylist?
        this.debugInformationLines = new ArrayList<String>();
    }
    //what does method Screen make?
    public Screen(String[] lines) { //why String[], not String()
        this(); //??
        this.setContent(lines);
    }
    //clears screen --> isn`` that method already implemented in ChooseScreen?
    public void clear() {
        this.lines.clear();
        this.debugInformationLines.clear();
    }

    //prepend does not work; what does it do?
    public void prepend(String[] lines) {
        this.lines.addAll(0, Arrays.asList(lines));
    }

    //method that visualizes a String declared beforehand
    public void append(String[] lines) {
        TextTools.append(this.lines, lines);
    }

    //different append and appendLine?
    public void appendLine(String s) {
        this.lines.add(s);
    }

    public String[] getContent() {
        //creates new empty array, which is faster than allocating an array of the right size directly
        //what does it make? example?
        return lines.toArray(new String[0]);
    }

    //clears ols content, visualizes new content
    public void setContent(String[] lines) {
        this.clear();
        this.append(lines);
    }

    //does it work? what does it make?
    public void setDebugInformation(String[] values) {
        this.debugInformationLines.clear();
        for (String value : values) {
            this.debugInformationLines.add(value);
        }
    }

}
