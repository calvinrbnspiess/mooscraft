package de.on19.mooscraft.game.characters;

public class WhiteMage extends Character {

    public WhiteMage() {
        super(80, 10, 35, 20, 50);
    }

    public static String getGreeting() {
        return "> \u001b[1;96mIch bin der Weiße Magier Kelii.\u001b[0m";
    }

    public static String[] getIcon() {
        String[] icon = new String[]{
                "        ^ ",
                "       ( ) ",
                "       \\ / ",
                "        | ",
                "        | ",
                "        | ",
                "        | ",
                "        | ",
                "        | ",
                "       | | ",
                "       |_| ",
        };

        return icon;
    }

    public static String getDescription() {
        String description = "Ich bin der älteste Charakter in Mooscraft; jedoch nur äußerlich. Auf den ersten Blick mag mein sehr langer weißer Bart aussehen als wäre ich gealtert. Jedoch habe ich Mittels meiner \u001b[1;91mWeisheit [50]\u001b[0m einen Zaubertrank entwickelt, welcher mich stets auf dem Stand eines 25 Jahre jungen Burschen hält. Meine \u001b[1;91mLebensenergie [80]\u001b[0m reicht aus um den Weg mit etwas Geschick zu meistern. Als Urgestein der Magie habe ich natürlich auch stets einen Zauberspruch zur Verteidigung auf den Lippen \u001b[1;91mZauberkraft [35]\u001b[0m. Leider hat der Jungtrunk auf Dauer eine kleine Nebenwirkung. Er wirkt sich auf meine \u001b[1;91mWillenskraft [20]\u001b[0m aus worauf hin ich kurzzeitig zum Komiker mutiere \u001b[1;91m(Willenskraft [20])\u001b[0m.";

        return description;
    }
}