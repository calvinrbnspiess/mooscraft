package de.on19.mooscraft.game.characters;

public class MermaidMan extends Character {

    public MermaidMan() {
        super(50, 40, 10, 40, 30);
    }

    public static String getGreeting() {
        return ">>> \u001b[1;96mIch bin Meerjungfraumann Marin.\u001b[0m <<<";
    }

    public static String[] getIcon() {
        String[] icon = new String[]{
                " >\u001b[1;91m                  ",
                ".oko;.                ",
                " ,kXWKc               ",
                "  ,0MM0c.      .';llo,",
                "  .:OWMWXkl:okOXNNWXc ",
                "    ;0WMMMMMMMMMKc;'  ",
                "     .,oKMMMMOcc'     ",
                "       .OMMM0,        ",
                "      ,0MMMMX:        ",
                "     ,0MMWWx.         ",
                "     :KMMMWO'         ",
                "    :XMMMMWWk.        ",
                "    'OMMMMMMXl        ",
                "    lNMMMMMMMO'       ",
                "    :XMMMMMMMNo.      ",
                "   .xWMMMMMMMMW0:     ",
                "    lNMMMMMMMMMWo    \u001b[0m  ",
        };

        return icon;
    }

    public static String getDescription() {
        String description = "Im Wasser bin ich unschlagbar. Dort ist meine Heimat und diese beschütze ich " +
                "mit den mir gegebenen Fähigkeiten \u001b[1;91m(Willenskraft [40])\u001b[0m. Geboren bin ich im " +
                "Fluss Mittelklinge, welchen ich kenne wie meine Westentasche, da ich nun schon ein Weilchen auf " +
                "dieser Welt wandle \u001b[1;91m(Lebensenergie [50])\u001b[0m. Wählst du mich, sind deine Chancen " +
                "auf Land geringer, dafür im Wasser umso höher. Auch an \u001b[1;91mStärke [40]\u001b[0m habe ich " +
                "über die Jahre zugelegt und bekämpfe in der Nähe von Wasser jeden Gegner. Mit \u001b[1;" +
                "91mZauberkraft [10]\u001b[0m oder tiefer  \u001b[1;91mWeisheit [30]\u001b[0m kann ich dagegen nicht " +
                "auftrumphen.";

        return description;
    }


}
