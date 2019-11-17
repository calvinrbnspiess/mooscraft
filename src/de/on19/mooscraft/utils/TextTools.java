package de.on19.mooscraft.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextTools {


    public static final String MATCH_NON_WORDS = "[^\\p{L}+]";
    public static final String MATCH_WHITESPACE = "\\s";
    public static int TERMINAL_WIDTH = 112;
    public static int TERMINAL_PADDING = 12;

    public static String repeat(String string, int length) {
        String output = "";
        for (int i = 0; i < length; i++) {
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
        // TODO no whitespaces?

        // decrease maxChars by one to make space for line-break-indicator
        if (!text.contains(" ")) {
            for (int i = maxChars; i <= text.length(); i += maxChars) {
                text = text.substring(0, i - 1) + System.lineSeparator() + text.substring(i - 1);
            }
            return text;
        }

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
        // TODO no whitespaces?

        //remove whitespace at beginning and end of string
        //then remove consecutive whitespace
        text = text.trim().replaceAll("\\s{2,}", " ");

        // fix bug when entering a too short string
        if (text.length() <= maxChars) {
            return new String[]{text};
        }

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

    public static String[] centerInRow(String[] rows, int maxChars) {
        List<String> formattedLines = new ArrayList<String>();
        for (String line : rows) {
            formattedLines.add(centerInRow(line, maxChars));
        }

        return formattedLines.toArray(new String[0]);
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

    /**
     * Tests case-insensitive whether a string contains another one
     *
     * @param inWhich string on which it should be determined whether it contains the wanted string
     * @param wanted  string which should be contained
     * @return true or false
     */
    public static boolean contains(String inWhich, String wanted) {
        return inWhich.toLowerCase().contains(wanted.toLowerCase());
    }
}
