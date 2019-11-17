package de.on19.mooscraft.game;

import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.characters.*;
import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.actions.*;
import de.on19.mooscraft.game.screens.ChooseScreen;
import de.on19.mooscraft.game.screens.GameOverScreen;
import de.on19.mooscraft.game.screens.Screen;
import de.on19.mooscraft.game.screens.SplashScreen;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.game.worlds.world1.World1;
import de.on19.mooscraft.game.worlds.world2.World2;
import de.on19.mooscraft.game.worlds.world3.World3;
import de.on19.mooscraft.game.worlds.world4.World4;
import de.on19.mooscraft.renderer.Renderer;
import de.on19.mooscraft.utils.TextTools;

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

    // print screen and status information
    public void printGameScreen(Screen prior) {
        Screen screen = new Screen();
        screen.append(this.getStatsIndicator(this.character));
        screen.append(TextTools.emptyLines(1));
        screen.append(prior.getContent());

        this.renderer.printScreen(screen, true);
    }

    public int getSpotsAmount() {
        int i = 0;
        for (World w : this.worlds) {
            i += w.getPathLength();
        }
        return i;
    }

    public String getPlayerIndicator(Character character) {
        String name = "Spieler: " + character.getName() + " (" + this.getCharacterClass(character) + ")";
        String health = "Lebensenergie (" + character.getHealth() + "/100) " + TextTools.repeat("❤", (int) Math.ceil((float) character.getHealth() / 10)) + TextTools.repeat("○", (int) Math.floor((float) (100 - character.getHealth()) / 10));

        int indicatorLength = name.length() + health.length();
        int remainingSpace = TextTools.TERMINAL_WIDTH - indicatorLength; // should not be (x < 0)

        return health + TextTools.repeat(" ", remainingSpace) + name;
    }

    public String[] getStatsIndicator(Character character) {
        String strength = "Stärke " + character.getStrength() + "/50";
        String witchcraft = "Zauberkraft " + character.getWitchcraft() + "/50";
        String willpower = "Willenskraft " + character.getWillpower() + "/50";
        String wisdom = "Weisheit " + character.getWisdom() + "/50";

        int statusLength = strength.length() + witchcraft.length() + willpower.length() + wisdom.length();
        int remainingSpace = TextTools.TERMINAL_WIDTH - statusLength; // should not be (x < 0)

        // 4 properties -> 3 gaps between
        String surroundingSpace = TextTools.repeat(" ", (int) Math.ceil(remainingSpace / 3));

        String statusLine = strength + surroundingSpace + witchcraft + surroundingSpace + willpower + surroundingSpace + wisdom;

        return new String[]{
                TextTools.repeat("━", TextTools.TERMINAL_WIDTH),
                this.getPlayerIndicator(character),
                statusLine,
                TextTools.repeat("━", TextTools.TERMINAL_WIDTH),
                this.getProgressIndicator(character),
                TextTools.repeat("━", TextTools.TERMINAL_WIDTH)
        };
    }

    public String getCharacterClass(Character character) {
        switch (character.getClass().getSimpleName()) {
            case "MermaidMan":
                return "Meerjungfraumann";
            case "Rogue":
                return "Schurke";
            case "Warrior":
                return "Kriegerin";
            case "WhiteMage":
                return "Weißer Magier";
            case "Witch":
                return "Hexe";
        }
        return "Charakter";
    }

    public String getProgressIndicator(Character character) {
        String indicator = "Fortschritt ";

        int visitedSpots = character.getVisitedSpots();
        int iterationIndex = 0;

        // Game.TERMINAL_PADDING8chars terminal width, 4 chars percentage, and two chars for each progressbar on each side
        int indicatorLength = (int) Math.floor((TextTools.TERMINAL_WIDTH - 4 - indicator.length() - (this.worlds.size() * 2)) / this.worlds.size());
        for (World w : this.worlds) {
            indicator = indicator + "|";

            int indicatorSpotLength = (int) indicatorLength / w.getPathLength();
            for (int i = 0; i < w.getPathLength(); i++) {
                iterationIndex++;
                indicator += TextTools.repeat(visitedSpots >= iterationIndex ? "█" : "░", indicatorSpotLength);
            }

            indicator = indicator + "|";
        }

        int spots = this.getSpotsAmount();
        // java can't do integer division -> always zero
        float percentage = (float) visitedSpots / (float) spots * 100;

        indicator = indicator + " " + Math.round(percentage) + "%";

        return TextTools.centerInRow(indicator, TextTools.TERMINAL_WIDTH);
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

        //intro World
        String continueMessage = "Gib <weiter> ein, um fortzufahren.";
        String skipMessage = continueMessage + " Du kannst mit <überspringen> direkt zur Auswahl springen.";

        Screen intro = new Screen();
        intro.append(new String[]{TextTools.centerInRow("≈≈≈ Wähle deinen Charakter ≈≈≈", TextTools.TERMINAL_WIDTH)});
        intro.append(TextTools.emptyLines(1));
        intro.append(TextTools.addPadding("Um die Welt zu durchqueren und die Burg zu erobern kannst du zwischen verschiedenen Kreaturen von Mooscraft wählen. Im Folgenden stellen wir Sie dir vor.", TextTools.TERMINAL_WIDTH, TextTools.TERMINAL_PADDING));
        intro.append(TextTools.emptyLines(1));
        intro.appendLine(skipMessage);

        renderer.printScreen(intro);

        SkippableContinueAction skippableAction = new SkippableContinueAction("Bitte gib 'weiter' ein, um die Charakterbeschreibungen anzuzeigen. Du kannst mit 'überspringen' direkt zur Auswahl springen.");

        handler.waitForAction(skippableAction);

        /**
         *  Ablauf:
         *      - Splashscreen, warten auf <weiter>
         *      - Charakter-Auwahl Into, warten auf <weiter> oder <überspringen>
         *      - Beschreibung Hexe (1/5), warten auf <weiter> oder <überspringen>
         *      - Beschreibung Kriegerin (2/5), warten auf <weiter> oder <überspringen>
         *      - Beschreibung Weißer Magier (3/5), warten auf <weiter> oder <überspringen>
         *      - Beschreibung Schurke (4/5), warten auf <weiter> oder <überspringen>
         *      - Beschreibung Meerjungfraumann (5/5), warten nur auf <weiter>
         *      - Abfrage Charakter-Auswahl, warten auf <weiter>
         *      - Namens-Auswahl, warten auf <weiter>
         *      - Nacheinader alle Welten bzw. Spots, dazwischen warten auf <weiter>
         *      - Burg
         */

        if (!skippableAction.isSkipped()) {
            //Intro Hexe Magalia
            Screen magalia = new Screen();
            magalia.appendLine(TextTools.centerInRow(Witch.getGreeting(), TextTools.TERMINAL_WIDTH));
            magalia.append(TextTools.emptyLines(2));
            magalia.append(TextTools.centerInRow(Witch.getIcon(), TextTools.TERMINAL_WIDTH));
            magalia.append(TextTools.emptyLines(2));
            magalia.append(Witch.getDescriptionArray());
            magalia.append(TextTools.emptyLines(2));
            magalia.appendLine("(1/5) " + skipMessage);

            renderer.printScreen(magalia);
            handler.waitForAction(skippableAction);
        }

        if (!skippableAction.isSkipped()) {
            //Intro Kriegerin Bellatrix
            Screen bellatrix = new Screen();
            bellatrix.appendLine(TextTools.centerInRow(Warrior.getGreeting(), TextTools.TERMINAL_WIDTH));
            bellatrix.append(TextTools.emptyLines(2));
            bellatrix.append(TextTools.centerInRow(Warrior.getIcon(), TextTools.TERMINAL_WIDTH));
            bellatrix.append(TextTools.emptyLines(2));
            bellatrix.append(TextTools.addPadding(Warrior.getDescription(), TextTools.TERMINAL_WIDTH, TextTools.TERMINAL_PADDING));
            bellatrix.append(TextTools.emptyLines(2));
            bellatrix.appendLine("(2/5) " + skipMessage);

            renderer.printScreen(bellatrix);
            handler.waitForAction(skippableAction);
        }

        if (!skippableAction.isSkipped()) {
            //Intro White Mage Kelii
            Screen kelii = new Screen();
            kelii.appendLine(TextTools.centerInRow(WhiteMage.getGreeting(), TextTools.TERMINAL_WIDTH));
            kelii.append(TextTools.emptyLines(2));
            kelii.append(TextTools.centerInRow(WhiteMage.getIcon(), TextTools.TERMINAL_WIDTH));
            kelii.append(TextTools.emptyLines(2));
            kelii.append(TextTools.addPadding(WhiteMage.getDescription(), TextTools.TERMINAL_WIDTH, TextTools.TERMINAL_PADDING));
            kelii.append(TextTools.emptyLines(2));
            kelii.appendLine("(3/5) " + skipMessage);

            renderer.printScreen(kelii);
            handler.waitForAction(skippableAction);
        }

        if (!skippableAction.isSkipped()) {
            //Intro Rogue Bandito
            Screen bandito = new Screen();
            bandito.appendLine(TextTools.centerInRow(Rogue.getGreeting(), TextTools.TERMINAL_WIDTH));
            bandito.append(TextTools.emptyLines(2));
            bandito.append(TextTools.centerInRow(Rogue.getIcon(), TextTools.TERMINAL_WIDTH));
            bandito.append(TextTools.emptyLines(2));
            bandito.append(TextTools.addPadding(Rogue.getDescription(), TextTools.TERMINAL_WIDTH, TextTools.TERMINAL_PADDING));
            bandito.append(TextTools.emptyLines(2));
            bandito.appendLine("(4/5) " + skipMessage);

            renderer.printScreen(bandito);
            handler.waitForAction(skippableAction);
        }

        if (!skippableAction.isSkipped()) {
            //Intro Mermaidman Marin
            Screen marin = new Screen();
            marin.appendLine(TextTools.centerInRow(MermaidMan.getGreeting(), TextTools.TERMINAL_WIDTH));
            // marin.append(TextTools.emptyLines(2)); // take too much space by him
            marin.append(TextTools.centerInRow(MermaidMan.getIcon(), TextTools.TERMINAL_WIDTH));
            marin.append(TextTools.emptyLines(1));
            marin.append(TextTools.addPadding(MermaidMan.getDescription(), TextTools.TERMINAL_WIDTH, TextTools.TERMINAL_PADDING));
            marin.append(TextTools.emptyLines(1)); // mermaidman has way too much text - so only 1 empty line instead of two like the other characters
            marin.appendLine("(5/5) " + continueMessage);

            renderer.printScreen(marin);
            // by last character description a skip is not neccessary anymore
            handler.waitForAction(new ContinueAction());
        }
        //intro World
        ChooseScreen chooseCharacter = new ChooseScreen();
        chooseCharacter.append(new String[]{TextTools.centerInRow("≈≈≈ Wähle deinen Charakter ≈≈≈", TextTools.TERMINAL_WIDTH)});
        chooseCharacter.append(TextTools.emptyLines(2));
        String introWorld = "Du hast verstanden und eine Wahl getroffen? Vergiss nicht: Wähle deine Eigenschaften gut aus, denn der Weg zur Burg kann tückisch sein.";
        chooseCharacter.append(TextTools.addPadding(introWorld, TextTools.TERMINAL_WIDTH, TextTools.TERMINAL_PADDING));

        chooseCharacter.addOptions(new String[]{
                "Magalia (Hexe)",
                "Bellatrix (Kriegerin)",
                "Weißer Magier",
                "Schurke",
                "Meerjungfraumann"
        });
        chooseCharacter.setInstruction("Triff eine weise Entscheidung, indem du eine der Optionen eingibst.");

        renderer.printScreen(chooseCharacter, true);

        ChooseAction chooseAction = new ChooseAction(chooseCharacter);

        // character needs to be uniquely chosen
        while (chooseAction.getChosenOption() == null) {
            handler.waitForAction(chooseAction);

            if (chooseAction.getChosenOption() == null) {
                Screen s = new Screen();
                s.appendLine("Du hast keine eindeutige Option gewählt. Probier's nochmal.");
                renderer.printScreen(s, false);
            }
        }

        String chosenOption = chooseAction.getChosenOption();
        String[] formattedOptions = chooseCharacter.getFormattedOptions();

        if (formattedOptions[0].equals(chosenOption)) {
            character = new Witch();
        } else if (formattedOptions[1].equals(chosenOption)) {
            character = new Warrior();
        } else if (formattedOptions[2].equals(chosenOption)) {
            character = new WhiteMage();
        } else if (formattedOptions[3].equals(chosenOption)) {
            character = new Rogue();
        } else if (formattedOptions[4].equals(chosenOption)) {
            character = new MermaidMan();
        }

        Screen chooseName = new Screen();
        chooseName.append(new String[]{TextTools.centerInRow("≈≈≈ Bitte gib einen Namen ein ≈≈≈", TextTools.TERMINAL_WIDTH)});
        chooseName.append(TextTools.emptyLines(1));
        chooseName.append(TextTools.addPadding("Herzlichen Glückwunsch! Du hast den Charakter '" + getCharacterClass(character) + "' gewählt! Du kannst nun einen Namen für dich wählen:", TextTools.TERMINAL_WIDTH, TextTools.TERMINAL_PADDING));
        renderer.printScreen(chooseName, true);

        handler.waitForAction(new GameAction() {

            @Override
            public void onCommand(String[] args, ActionHandler handler) {
                character.setName(args[0]);
            }
        });

        character.prepareGameOverScreen(new GameOverScreen(this));

        Screen printName = new Screen();
        printName.append(new String[]{TextTools.wrapToLength("Viel Erfolg auf deinem Weg " + character.getName(), TextTools.TERMINAL_WIDTH)});
        renderer.printScreen(printName, true);

        for (World w : this.worlds) {
            w.onEnter(this, character);
        }


        //new Screen for last action: win the castle
        String castleHeadline = "≈≈≈ Die Burg Arcis Borbetomagus ≈≈≈";
        String[] castleIcon = new String[]{
                "              :0Oc.             ",
                "              cNWN0Odoc;'..     ",
                "              cWMMMMMMMWNX0kdl' ",
                "              cWMMMMMWX0Oxoc;,. ",
                "              cNN0oc:,..        ",
                "              cX0;              ",
                ".odl.  :dd;  .OWNx.  :dd;  'ddl.",
                ";XMX; .xMMd  :NMMK, .kMMd  cNMK,",
                ";XMNOdxXMMKxd0WMMNOdkXMMKxd0WM0,",
                ";XMMMMMMMMMMMMMMMMMMMMMMMMMMMMK,",
                ";XMMMMMMMMMMMMMMMMMMMMMMMMMMMMK,",
                "'ONNWMMMMMMMMMMMMMMMMMMMMMMWNNx.",
                " .',kMMMMMMMMMMMMMMMMMMMMMWd'.. ",
                "   .OMMMMMMMMMWWWMMMMMMMMMMx.   ",
                "   ;XMMMMMMW0l;,,;oKWMMMMMM0'   ",
                "   oMMMMMMMO.      ,0MMMMMMWc   ",
                "  .OMMMMMMMx.      .kMMMMMMMx.  ",
                "  :NMMMMMMMd       .kMMMMMMMK,  ",
                "  dMMMMMMMMd       .kMMMMMMMWl  ",
                " '0MMMMMMMMKdooooooxXMMMMMMMMk. ",
                " cNMMMMMMMMMMMMMMMMMMMMMMMMMMX; ",
                ".xMMMMMMMMMMMMMMMMMMMMMMMMMMMWo ",
                ",KMMMMMMMMMMMMMMMMMMMMMMMMMMMMO.",
                ".oOOOOOOOOOOOOOOOOOOOOOOOOOOOkl."
        };
        String wonCastle = "Hurraaaaaa! Du warst mächtig genug, um die Monster von Mooscraft zu besiegen. Das Volk ist dir zu ewiger Treue verpflichtet, da du es von den Qualen der Monster Mester und Preisler befreit hast. Damit dein Volk dich gebührend huldigen kann, erklimme mit Hilfe deiner verbliebenen Lebensenergie die Mauern der Burg Arcis Borbetomagus. Nun kannst du ganz Mooscraft überblicken mit seinem grünen Odenwald, der rauschenden Mittelklinge, dem zauberhaften Hexenturm Turismaga. Lass dich als neue/r Herrscher/in von Mooscraft gebührend feiern.";
        String lostCastle = "Oh nein! Die Kämpfe gegen die Monster Mester und Preisler haben dir die letzte Lebensenergie geraubt und du stürtzt beim Erklimmen der Burg Arcis Borbetomagus die Wände hinunter in die Tiefe. Doch eine verlorene Schlacht ist kein verlorener Krieg. Wähle deine Parameter weiser und trau dich erneut durch die Pforten von Mooscraft.";

        Screen castle = new Screen();
        castle.appendLine(TextTools.centerInRow(castleHeadline, TextTools.TERMINAL_WIDTH));
        castle.append(TextTools.emptyLines(1));
        castle.append(TextTools.centerInRow(castleIcon, TextTools.TERMINAL_WIDTH));
        castle.append(TextTools.emptyLines(1));
        castle.appendLine(TextTools.centerInRow("In ewiger Treue, '" + character.getName() + "'!", TextTools.TERMINAL_WIDTH));

        if (character.getHealth() >= 25) {
            castle.append(TextTools.addPadding(wonCastle, TextTools.TERMINAL_WIDTH, TextTools.TERMINAL_PADDING));
        } else {
            castle.append(TextTools.addPadding(lostCastle, TextTools.TERMINAL_WIDTH, TextTools.TERMINAL_PADDING));
        }
        castle.append(TextTools.emptyLines(2));
        castle.appendLine(TextTools.centerInRow("Punktzahl: " + Math.round((float) (character.getWillpower() * character.getWitchcraft() * character.getStrength() * character.getWisdom()) / 10), TextTools.TERMINAL_WIDTH));
        castle.append(TextTools.emptyLines(2));
        castle.appendLine("Du kannst das Spiel nun mit <exit> verlassen.");
        renderer.printScreen(castle);

        this.getHandler().waitForAction(new ExitAction());
    }

    public Renderer getRenderer() {
        return this.renderer;
    }

    public ActionHandler getHandler() {
        return this.handler;
    }

    public Character getCharacter() {
        return this.character;
    }
}