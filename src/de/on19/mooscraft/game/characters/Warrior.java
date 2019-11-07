package de.on19.mooscraft.game.characters;

public class Warrior extends Character {
    public Warrior() {
        super(80, 50, 10, 40, 10);
    }

    public static String getGreeting() {
        return "> \u001b[1;96mIch bin Kriegerin Bellatrix.\u001b[0m";
    }

    public static String[] getIcon() {
        String[] icon = new String[]{
                "        ^",
                "       / \\",
                "        | ",
                "        | ",
                "        | ",
                "        | ",
                "        | ",
                "        | ",
                "        | ",
                "       / \\",
                "       / \\",
        };

        return icon;
    }

    public static String getDescription() {
        String description = "Meine Aufgabe ist es im Land meines Vaters, dem Herrscher von Arcis Borbetomagus, die Burg in Worms vor unerwünschten Eindringlingen zu bewahren. Ich komme in Frieden, aber besitze genügend \u001b[1;91mStärke [50]\u001b[0m und \u001b[1;91mWillenskraft [40]\u001b[0m um unser Land zu verteidigen. Als Tochter des Herrschers bin ich jung und voller \u001b[1;91mLebensenergie [80]\u001b[0m. Jedoch mangelt es mit an \u001b[1;91mZauberkraft [10]\u001b[0m und \u001b[1;91mWeisheit [10]\u001b[0m.";

        return description;
    }
}