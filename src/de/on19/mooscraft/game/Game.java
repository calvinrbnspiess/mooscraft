package de.on19.mooscraft.game;

import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.characters.*;
import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.interaction.actions.GameAction;
import de.on19.mooscraft.game.screens.ChooseScreen;
import de.on19.mooscraft.game.screens.SplashScreen;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.game.worlds.world1.World1;
import de.on19.mooscraft.game.worlds.world2.World2;
import de.on19.mooscraft.game.worlds.world3.World3;
import de.on19.mooscraft.game.worlds.world4.World4;
import de.on19.mooscraft.renderer.Renderer;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

import java.util.List;

public class Game {
    //contains game logik

    private Renderer renderer;
    private ActionHandler handler;
    private Character character;
    private List<World> worlds;

    public Game(Renderer renderer, ActionHandler handler) {
        this.renderer = renderer;
        this.handler = handler;
        this.character = null;
        this.worlds = List.of(new World1(), new World2(), new World3(), new World4());
    }

    public int getSpotsAmount() {
        int i = 0;
        for(World w : this.worlds) {
            i += w.getPathLength();
        }
        return i;
    }

    public String getProgressIndicator(Character character) {
        String indicator = "";

        int visitedSpots = character.getVisitedSpots();
        int iterationIndex = 0;

        for(World w : this.worlds) {
            indicator = indicator + "[";

            for(int i = 0 ; i < w.getPathLength(); i++) {
                iterationIndex++;
                indicator += visitedSpots >= iterationIndex ? "#" : "_";
            }

            indicator = indicator + "]";
        }

        int spots = this.getSpotsAmount();
        // java can't do integer division -> always zero
        float percentage = (float) visitedSpots / (float) spots * 100;

        indicator = indicator + " " + Math.round(percentage) + "%";

        return indicator;
    }

    //sequential processing of the following lines
    public void run() throws InterruptedException, UnsupportedOperationException {
        //shows start screen
        renderer.printScreen(new SplashScreen(handler));

        /** --- NEW --- changed this to be a seperate action */
        /** waits for any interaction by typing "weiter" into keyboard
         if no action or other actions follows --> see method onCommand
         */
        handler.waitForAction(new ContinueAction());

        ChooseScreen chooseCharacter = new ChooseScreen();

        //intro World
        String introWorld = "Um die Welt zu durchqueren und die Burg " +
                "                zu erobern kannst du zwischen verschiedenen Kreaturen von Mooscraft wählen. " +
                "Wähle deine Eigenschaften gut aus, denn der Weg zur Burg kann tückisch sein.";
        chooseCharacter.append(StringTools.addPadding(introWorld, 112, 12));
        chooseCharacter.append(StringTools.emptyLines(2));
        //Intro Hexe Magalia
        String helloHexe = "\u001b[1;96mIch bin Hexe Magalia.[0m";
        String[] iconWitch =                new String[]{
                "        ^ ",
                "       / \\ ",
                "        \\  \\",
                "        /   \\",
                "       /    /",
                "      /     \\",
                "     /       \\",
                "    /          \\",
                " \\_/____________\\_/",
                "  \\______________/ "};

        chooseCharacter.append(StringTools.addPadding(helloHexe, 112, 12));
        chooseCharacter.append(iconWitch);

        String hexe1 = "Ich helfe dir durch das Spiel mit meinen dunklen, bösen Zaubertränken. Mein Ziel ist " +
                "es die Macht mit Hilfe der Magie an mich zu reißen. Ich will alles beherrschen und durch " +
                "meine Dämonenbeschwörungen allem Sterblichem ein Ende setzen.";
        chooseCharacter.append(StringTools.emptyLines(1));
        chooseCharacter.append(StringTools.addPadding(hexe1, 112, 12));
        String hexe2 = "Ego fuo dius imperium Turrismaga!!!";
        chooseCharacter.append(StringTools.emptyLines(1));
        chooseCharacter.append(StringTools.addPadding(hexe2, 112, 12));
        String hexe3 = "Wählst du mich als Spielcharakter, so erhälst du die größte \u001b[1;91mWillenskraft " +
                "[50]\u001b[0m um ans " +
                "Ziel zu kommen. Gefahren des Weges Bescheid. Jedoch bin ich dementsprechend alt und habe " +
                "nicht mehr so viel Lebensenergie \u001b[1;91m[25]\u001b[0m und \u001b[1;91mStärke [20]\u001b[0m. Dafür " +
                "sind meine \u001b[1;91mZauberkraft [40]\u001b[0m und \u001b[1;91mWeisheit [30]\u001b[0m umso stärker.";
        chooseCharacter.append(StringTools.addPadding(hexe3, 112, 12));
        chooseCharacter.append(StringTools.emptyLines(2));

        //Intro Kriegerin Bellatrix
        String helloWarrior = "\u001b[1;96mIch bin Kriegerin Bellatrix.[0m";
        String[] iconWarrior = new String[] {
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

        chooseCharacter.append(StringTools.addPadding(helloWarrior, 112, 12));
        chooseCharacter.append(iconWarrior);

        String warrior1 = "Meine Aufgabe ist es im Land meines Vaters, dem Herrscher von Arcis Borbetomagus," +
                "die Burg in Worms vor unerwünschten Eindringlingen zu bewahren. Ich komme in Frieden, aber " +
                "besitze genügend \u001b[1;91mStärke [50]\u001b[0m und \u001b[1;91mWillenskraft [40]\u001b[0m um unser " +
                "Land zu verteidigen. Als Tochter des Herrschers bin ich jung und voller \u001b[1;" +
                "91mLebensenergie [80]\u001b[0m. " +
                "Jedoch mangelt es mit an \u001b[1;91mZauberkraft [10]\u001b[0m und \u001b[1;91mWeisheit [10]\u001b[0m.";
        chooseCharacter.append(StringTools.addPadding(warrior1, 112, 12));
        chooseCharacter.append(StringTools.emptyLines(2));

        //Intro White Mage Kelii
        String helloWhiteMage = "\u001b[1;96mIch bin der Weiße Magier Kelii.[0m";
        String[] iconWhiteMage= new String[]{
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
        chooseCharacter.append(StringTools.addPadding(helloWhiteMage, 112, 12));
        chooseCharacter.append(iconWhiteMage);

        String whiteMage1 = "Ich bin der älteste Charakter in Mooscraft; jedoch nur äußerlich. Auf den ersten" +
                " Blick mag mein sehr langer weißer Bart aussehen als wäre ich gealtert. Jedoch habe ich " +
                "Mittels meiner \u001b[1;91mWeisheit [50]\u001b[0m einen Zaubertrank entwickelt, welcher mich stets" +
                " auf dem Stand eines 25 Jahre jungen Burschen hält. Meine \u001b[1;91mLebensenergie [80]\u001b[0m " +
                "reicht aus um den Weg mit etwas Geschick zu meistern. Als Urgestein der Magie habe ich natürlich auch stets einen " +
                "Zauberspruch zur Verteidigung auf den Lippen \u001b[1;91mZauberkraft [35]\u001b[0m. Leider hat der" +
                " Jungtrunk auf Dauer eine kleine Nebenwirkung. Er wirkt sich auf meine \u001b[1;" +
                "91mWillenskraft [20]\u001b[0m aus worauf hin ich kurzzeitig zum Komiker mutiere \u001b[1;91m" +
                "(Willenskraft [20])\u001b[0m.";
        chooseCharacter.append(StringTools.addPadding(whiteMage1, 112, 12));
        chooseCharacter.append(StringTools.emptyLines(2));

        //Intro Rogue Bandito
        String hellorogue = "\u001b[1;96mIch bin der Schurke Bandito.[0m";
        String[] iconRogue = new String[] {
                "           ^ " ,
                "          / \\ ",
                "          | |  ",
                "          | |  ",
                "          | |  ",
                "          | |  ",
                "          | |  ",
                "        _______",
                "        -------",
                "          | | ",
                "          |_| ",
        };

        chooseCharacter.append(StringTools.addPadding(helloWhiteMage, 112, 12));
        chooseCharacter.append(iconRogue);
        String rogue1 = "Meine Hinterhalte sind deine Fallen. Mit schlauen Tricks verzerre ich deine " +
                "Sinneswahrnehmung und nichts ist mehr so wie es scheint \u001b[1;91m(Willenskraft [30])" +
                "\u001b[0m. Ich bin klug und fix \u001b[1;91m(Lebensenergie [70])\u001b[0m. Ich kann mich schnell auf Land " +
                "fortbewegen und kenne die besten Verstecke. Wählst du mich, bist du cleverer als die Anderen und durchblickst jede " +
                "Situation mit einem kühlen Kopf. Vor Wasser bin ich allerdings scheu und durch meine " +
                "Cleverness mussten meine Muskeln leiden. Dadurch ist meine \u001b[1;91mStärke [30]\u001b[0m nicht " +
                "ausreichend für einen Kampf auf Augenhöhe. Außerdem bin ich wenig bewandert in den Feldern der Zauberkraft und des" +
                " Wissens, wodurch ich nur wenig \u001b[1;91mZauberkraft [10]\u001b[0m und \u001b[1;91mWeisheit " +
                "[10]\u001b[0m bieten kann.";
        chooseCharacter.append(StringTools.addPadding(rogue1, 112, 12));
        chooseCharacter.append(StringTools.emptyLines(2));

        //Intro Mermaidman Marin
        String[] iconMermaidMan = new String[]{
                "                                              .                                                                 ",
                "                                             .oko;.                                                             ",
                "                                              ,kXWKc                                                            ",
                "                                               ,0MM0c.      .';llo,                                             ",
                "                                               .:OWMWXkl:okOXNNWXc                                              ",
                "                                                 ;0WMMMMMMMMMKc;'                                               ",
                "                                                  .,oKMMMMOcc'                                                  ",
                "                                                    .OMMM0,                                                     ",
                "                                                   ,0MMMMX:                                                     ",
                "                                                  ,0MMWWx.                                                      ",
                "                                                  :KMMMWO'                                                      ",
                "                                                 :XMMMMWWk.                                                     ",
                "                                                 'OMMMMMMXl                                                     ",
                "                                                 lNMMMMMMMO'                                                    ",
                "                                                 :XMMMMMMMNo.                                                   ",
                "                                                .xWMMMMMMMMW0:                                                  ",
                "                                                 lNMMMMMMMMMWo                                                  ",
        };

        String hellomermaidman = "\u001b[1;96mIch bin Meerjungfraumann Marin.[0m";
        chooseCharacter.append(StringTools.addPadding(hellomermaidman, 112, 12));

        chooseCharacter.append(iconMermaidMan);
        chooseCharacter.append(StringTools.emptyLines(1));

        String mermaidman1 = "Im Wasser bin ich unschlagbar. Dort ist meine Heimat und diese beschütze ich " +
                "mit den mir gegebenen Fähigkeiten \u001b[1;91m(Willenskraft [40])\u001b[0m. Geboren bin ich im " +
                "Fluss Mittelklinge, welchen ich kenne wie meine Westentasche, da ich nun schon ein Weilchen auf " +
                "dieser Welt wandle \u001b[1;91m(Lebensenergie [50])\u001b[0m. Wählst du mich, sind deine Chancen " +
                "auf Land geringer, dafür im Wasser umso höher. Auch an \u001b[1;91mStärke [40]\u001b[0m habe ich " +
                "über die Jahre zugelegt und bekämpfe in der Nähe von Wasser jeden Gegner. Mit \u001b[1;" +
                "91mZauberkraft [10]\u001b[0m oder tiefer  \u001b[1;91mWeisheit [30]\u001b[0m kann ich dagegen nicht " +
                "auftrumphen.";
        chooseCharacter.append(StringTools.addPadding(mermaidman1, 112, 12));
        chooseCharacter.append(StringTools.emptyLines(2));

        chooseCharacter.append(new String[]{StringTools.centerInRow("≈≈≈ Wähle deinen Charakter ≈≈≈", 112)});

        chooseCharacter.addOptions(new String[]{
                "Magalia (Hexe)",
                "Bellatrix (Kriegerin)",
                "Weißer Magier",
                "Schurke",
                "Meerjungfraumann"
        });
        chooseCharacter.setInstruction("Triff eine weise Entscheidung, indem du eine der Optionen eingibst.");

        renderer.printScreen(chooseCharacter, true);

        handler.waitForAction(new GameAction() {

            @Override
            public void onCommand(String[] args, ActionHandler handler) {
                // TODO user enters "." or only a part of option that is contained in every option
                // TODO should merge args to single string?
                if (StringTools.contains(chooseCharacter.getFormattedOptions()[0], args[0])) {
                    character = new Witch();
                } else if (StringTools.contains(chooseCharacter.getFormattedOptions()[1], args[0])) {
                    character = new Warrior();
                } else if (StringTools.contains(chooseCharacter.getFormattedOptions()[2], args[0])) {
                    character = new WhiteMage();
                } else if (StringTools.contains(chooseCharacter.getFormattedOptions()[3], args[0])) {
                    character = new Rogue();
                } else if (StringTools.contains(chooseCharacter.getFormattedOptions()[4], args[0])) {
                    character = new MermaidMan();
                }
            }
            /** getformattedoption: provides list with all options to choose
             * tolowerCase: changes strings provides with string to be compared in lowercase to make them
             * comparable independently of upper/lowercase
             * character gets chosen by typing in A-E, the full name or any part of the name
            *if wrong combinations is typed in --> no reaction; action handler waits. This gets tested via next lines
             * isInvoked not neccessary here (isInvoked->true is already defined in GameAction)
             */
        });

        Screen chooseName = new Screen();
        chooseName.append(new String[]{StringTools.centerInRow("≈≈≈ Bitte gebe einen Namen ein ≈≈≈", 112)});

        renderer.printScreen(chooseName, true);

        handler.waitForAction(new GameAction() {

            @Override
            public void onCommand(String[] args, ActionHandler handler) {
                character.setName(args[0]);
            }
        });

        Screen printName = new Screen();
        printName.append(new String[]{StringTools.wrapToLength("Viel Erfolg auf deinem Weg " + character.getName(), 112)});
        renderer.printScreen(printName, true);

        Thread.sleep(4000);

        for(World w : this.worlds) {
            w.onEnter(this, character);
        }
        // einzelne welten aufrufen -> onEnter -> danach burg

    }

    public Renderer getRenderer() {
        return this.renderer;
    }

    public ActionHandler getHandler() {
        return this.handler;
    }
}