package de.on19.mooscraft.game.characters;

public class Rogue extends Character {

    public Rogue() {
        super(70, 30, 10, 30, 10);
    }

    public static String getGreeting() {
        return ">>> Ich bin der Schurke Bandito. <<<";
    }

    public static String[] getIcon() {
        String[] icon = new String[]{
                "   ^   ",
                " / \\  ",
                "  | |  ",
                "  | |  ",
                "  | |  ",
                "  | |  ",
                "  | |  ",
                "_______",
                "-------",
                "  | |  ",
                "  |_|  ",
        };

        return icon;
    }

    public static String getDescription() {
        String description = "Meine Hinterhalte sind deine Fallen. Mit schlauen Tricks verzerre ich deine " +
                "Sinneswahrnehmung und nichts ist mehr so wie es scheint \u001b[1;91m(Willenskraft [30])" +
                "\u001b[0m. Ich bin klug und fix \u001b[1;91m(Lebensenergie [70])\u001b[0m. Ich kann mich schnell auf Land " +
                "fortbewegen und kenne die besten Verstecke. Wählst du mich, bist du cleverer als die Anderen und durchblickst jede " +
                "Situation mit einem kühlen Kopf. Vor Wasser bin ich allerdings scheu und durch meine " +
                "Cleverness mussten meine Muskeln leiden. Dadurch ist meine \u001b[1;91mStärke [30]\u001b[0m nicht " +
                "ausreichend für einen Kampf auf Augenhöhe. Außerdem bin ich wenig bewandert in den Feldern der Zauberkraft und des" +
                " Wissens, wodurch ich nur wenig \u001b[1;91mZauberkraft [10]\u001b[0m und \u001b[1;91mWeisheit " +
                "[10]\u001b[0m bieten kann.";

        return description;
    }
}
