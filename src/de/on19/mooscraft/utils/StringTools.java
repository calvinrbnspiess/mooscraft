package de.on19.mooscraft.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringTools {

    public static final String MATCH_NON_WORDS = "[^\\p{L}+]";
    public static final String MATCH_WHITESPACE = "\\s";

    public static String repeat(String string, int length) {
        String output = "";
        for (int i = 0; i <= length; i++) {
            output = output + string;
        }
        return output;
    }

    /**
     * Wraps words when specified maxChars are exceeded.
     *
     * @param text     string without line-breaks
     * @param maxChars desired maximum amount of characters per line
     * @return wrapped string
     */
    public static String wrapToLength(String text, int maxChars) {
        // TODO what will happen if a text value without spaces at all is given?

        //remove whitespace at beginning and end of string
        //then remove consecutive whitespace
        text = text.trim().replaceAll("\\s{2,}", " ");

        //go to last char of a line, check if there is a non-whitespace character, if not go left until start of word is reached, then replace whitespace with line-break
        for (int i = maxChars; i < text.length(); i += maxChars) {
            while (!Character.toString(text.charAt(i)).matches(MATCH_WHITESPACE)) {
                i -= 1;
            }
            text = text.substring(0, i) + System.lineSeparator() + text.substring(i + 1);
        }

        return text;
    }

    /**
     * Wraps words when specified maxChars are exceeded.
     *
     * @param text     string without line-breaks
     * @param maxChars desired maximum amount of characters per line
     * @return wrapped string
     */
    public static String[] wrapToLengthArray(String text, int maxChars) {
        // TODO what will happen if a text value without spaces at all is given?

        //remove whitespace at beginning and end of string
        //then remove consecutive whitespace
        text = text.trim().replaceAll("\\s{2,}", " ");

        List<String> lines = new ArrayList<String>();
        do {
            int position = maxChars;

            while (!Character.toString(text.charAt(position)).matches(MATCH_WHITESPACE)) {
                position -= 1;
            }
            lines.add(text.substring(0, position));
            //trims text to remaining length
            text = text.substring(position + 1);
        } while (text.length() > maxChars);
        lines.add(text);
        return lines.toArray(new String[0]);
    }


    public static String[] addPadding(String text, int maxChars, int padding) {
        int effectiveWrapLength = maxChars - padding * 2;
        String[] lines = wrapToLengthArray(text, effectiveWrapLength);

        for (int i = 0; i < lines.length; i++) {
            lines[i] = repeat(" ", padding) + lines[i];
        }

        return lines;
    }

    public static String centerInRow(String text, int maxChars) {
        int padding = Math.round((maxChars - text.length()) / 2);
        return repeat(" ", padding) + text;
    }

    public static String[] emptyLines(int amount) {
        String[] space = new String[amount];
        Arrays.fill(space, "");

        return space;
    }

    public static List<String> append(List<String> content, String[] lines) {
        for (String line : lines) {
            content.add(line);
        }
        return content;
    }
}