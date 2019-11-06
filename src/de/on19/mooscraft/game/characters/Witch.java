package de.on19.mooscraft.game.characters;

import de.on19.mooscraft.utils.StringTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Witch extends Character {
    /**extends me and that this class builds on an other class (here class Character). Therefore, the class
     * extends the overall class
     */

    public Witch() {
        super(25, 20, 40, 50, 30);
    }
    /**super calls constructor of Character class
     * know which constructor by comparison of used parameters
     */

    public static String getGreeting() {
        return "> \u001b[1;96m Ich bin Hexe Magalia.\u001b[0m";
    }

    public static String[] getIcon() {
        String[] iconMermaidMan = new String[]{
                "        ^ ",
                "       / \\ ",
                "        \\  \\",
                "        /   \\",
                "       /    /",
                "      /     \\",
                "     /       \\",
                "    /          \\",
                " \\_/____________\\_/",
                "  \\______________/ "
        };

        return iconMermaidMan;
    }

    public static String[] getDescriptionArray() {
        String description1 = "Ich helfe dir durch das Spiel mit meinen dunklen, bösen Zaubertränken. Mein Ziel ist es die Macht mit Hilfe der Magie an mich zu reißen. Ich will alles beherrschen und durch meine Dämonenbeschwörungen allem Sterblichem ein Ende setzen.";
        String description2 = "Ego fuo dius imperium Turrismaga!!!";
        String description3 = "Wählst du mich als Spielcharakter, so erhälst du die größte \u001b[1;91mWillenskraft " +
                "[50]\u001b[0m um ans " +
                "Ziel zu kommen. Gefahren des Weges Bescheid. Jedoch bin ich dementsprechend alt und habe " +
                "nicht mehr so viel \u001b[1;91mLebensenergie [25]\u001b[0m und \u001b[1;91mStärke [20]\u001b[0m. Dafür " +
                "sind meine \u001b[1;91mZauberkraft [40]\u001b[0m und \u001b[1;91mWeisheit [30]\u001b[0m umso stärker.";

        List<String> lines = new ArrayList<String>();

        lines.addAll(Arrays.asList(StringTools.addPadding(description1, 112, 12)));
        lines.add("");
        lines.addAll(Arrays.asList(StringTools.addPadding(description2, 112, 12)));
        lines.add("");
        lines.addAll(Arrays.asList(StringTools.addPadding(description3, 112, 12)));

        return lines.toArray(new String[0]);
    }

}
