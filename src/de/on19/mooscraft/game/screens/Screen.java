package de.on19.mooscraft.game.screens;

import de.on19.mooscraft.utils.TextTools;

import java.util.ArrayList;
import java.util.List;

public class Screen {

    private List<String> lines;

    //creates arraylist
    public Screen() {
        this.lines = new ArrayList<String>();
    }

    //visualizes content
    public Screen(String[] lines) {
        this();
        this.setContent(lines);
    }

    //clears screen
    public void clear() {
        this.lines.clear(); //clears initialized arrayList
    }

    //method that visualizes a Strings declared beforehand
    public void append(String[] lines) {
        TextTools.append(this.lines, lines);
    }

    //method that visualizes a String declared beforehand
    public void appendLine(String s) {
        this.lines.add(s);
    }

    public String[] getContent() {
        //creates new empty array, which is faster than allocating an array of the right size directly
        //provides standard content
        return lines.toArray(new String[0]);
    }

    //clears old content, visualizes new content
    public void setContent(String[] lines) {
        this.clear();
        this.append(lines);
    }

}
