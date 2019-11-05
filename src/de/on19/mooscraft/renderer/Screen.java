package de.on19.mooscraft.renderer;

import de.on19.mooscraft.utils.StringTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Screen {

    private List<String> lines;
    private List<String> debugInformationLines;

    public Screen() {
        this.lines = new ArrayList<String>();
        this.debugInformationLines = new ArrayList<String>();
    }

    public Screen(String[] lines) {
        this();
        this.setContent(lines);
    }

    public void clear() {
        this.lines.clear();
        this.debugInformationLines.clear();
    }

    public void prepend(String[] lines) {
        this.lines.addAll(0, Arrays.asList(lines));
    }

    public void append(String[] lines) {
        StringTools.append(this.lines, lines);
    }

    public void appendLine(String s) {
        this.lines.add(s);
    }

    public String[] getContent() {
        //creates new empty array, which is faster than allocating an array of the right size directly
        return lines.toArray(new String[0]);
    }

    public void setContent(String[] lines) {
        this.clear();
        this.append(lines);
    }

    public void setDebugInformation(String[] values) {
        this.debugInformationLines.clear();
        for (String value : values) {
            this.debugInformationLines.add(value);
        }
    }

}
