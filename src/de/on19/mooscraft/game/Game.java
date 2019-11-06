package de.on19.mooscraft.game;

import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.characters.*;
import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.actions.ChooseAction;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.interaction.actions.GameAction;
import de.on19.mooscraft.game.screens.ChooseScreen;
import de.on19.mooscraft.game.screens.GameOverScreen;
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

    // print screen and status information
    public void printGameScreen(Screen prior) {
        Screen screen = new Screen();
        screen.append(this.getStatsIndicator(this.character));
        screen.append(StringTools.emptyLines(1));
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
        String health = "Lebensenergie (" + character.getHealth() + "/100) " + StringTools.repeat("❤",  (int) Math.ceil((float) character.getHealth() / 10));

        int indicatorLength = name.length() + health.length();
        int remainingSpace = 112 - indicatorLength; // should not be (x < 0)

        return health + StringTools.repeat(" ", remainingSpace) + name;
    }

    public String[] getStatsIndicator(Character character) {
        String strength = "Stärke " + character.getStrength() + "/50";
        String witchcraft = "Zauberkraft " + character.getWitchcraft() + "/50";
        String willpower = "Willenskraft " + character.getWillpower() + "/50";
        String wisdom = "Weisheit " + character.getWisdom() + "/50";

        int statusLength = strength.length() + witchcraft.length() + willpower.length() + wisdom.length();
        int remainingSpace = 112 - statusLength; // should not be (x < 0)

        // 4 properties -> 3 gaps between
        String surroundingSpace = StringTools.repeat(" ", (int) Math.ceil(remainingSpace / 3));

        String statusLine = strength + surroundingSpace + witchcraft + surroundingSpace + willpower + surroundingSpace + wisdom;

        return new String[] {
                StringTools.repeat("━", 112),
                this.getPlayerIndicator(character),
            statusLine,
            StringTools.repeat("━", 112),
            this.getProgressIndicator(character),
                StringTools.repeat("━", 112)
        };
    }

    public String getCharacterClass(Character character) {
        switch(character.getClass().getSimpleName()) {
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

        // 128chars terminal width, 4 chars percentage, and two chars for each progressbar on each side
        int indicatorLength = (int) Math.floor((112 - 4 - indicator.length() - (this.worlds.size() * 2)) / this.worlds.size());
        for (World w : this.worlds) {
            indicator = indicator + "|";

            int indicatorSpotLength = (int) indicatorLength / w.getPathLength();
            for (int i = 0; i < w.getPathLength(); i++) {
                iterationIndex++;
                indicator += StringTools.repeat(visitedSpots >= iterationIndex ? "█" : "░", indicatorSpotLength);
            }

            indicator = indicator + "|";
        }

        int spots = this.getSpotsAmount();
        // java can't do integer division -> always zero
        float percentage = (float) visitedSpots / (float) spots * 100;

        indicator = indicator + " " + Math.round(percentage) + "%";

        return StringTools.centerInRow(indicator, 112);
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
        Screen intro = new Screen();
        intro.append(new String[]{StringTools.centerInRow("≈≈≈ Wähle deinen Charakter ≈≈≈", 112)});
        intro.append(StringTools.emptyLines(1));
        intro.appendLine("Um die Welt zu durchqueren und die Burg zu erobern kannst du zwischen verschiedenen Kreaturen von Mooscraft wählen. Im Folgenden stellen wir Sie dir vor.");
        intro.append(StringTools.emptyLines(1));
        intro.appendLine("Gib <weiter> ein, um fortzufahren.");

        renderer.printScreen(intro);

        handler.waitForAction(new ContinueAction());


        //Intro Hexe Magalia
        Screen magalia = new Screen();
        magalia.append(StringTools.addPadding(Witch.getGreeting(), 112, 12));
        magalia.append(StringTools.emptyLines(2));
        magalia.append(Warrior.getIcon());
        magalia.append(StringTools.emptyLines(2));
        magalia.append(Witch.getDescriptionArray());
        magalia.append(StringTools.emptyLines(2));
        magalia.appendLine("Gib <weiter> ein, um fortzufahren.");

        renderer.printScreen(magalia);
        handler.waitForAction(new ContinueAction());

        //Intro Kriegerin Bellatrix
        Screen bellatrix = new Screen();
        bellatrix.append(StringTools.addPadding(Warrior.getGreeting(), 112, 12));
        bellatrix.append(StringTools.emptyLines(2));
        bellatrix.append(Warrior.getIcon());
        bellatrix.append(StringTools.emptyLines(2));
        bellatrix.append(StringTools.addPadding(Warrior.getDescription(), 112, 12));
        bellatrix.append(StringTools.emptyLines(2));
        bellatrix.appendLine("Gib <weiter> ein, um fortzufahren.");

        renderer.printScreen(bellatrix);
        handler.waitForAction(new ContinueAction());

        //Intro White Mage Kelii
        Screen kelii = new Screen();
        kelii.append(StringTools.addPadding(WhiteMage.getGreeting(), 112, 12));
        kelii.append(WhiteMage.getIcon());
        kelii.append(StringTools.emptyLines(2));
        kelii.append(StringTools.addPadding(WhiteMage.getDescription(), 112, 12));
        kelii.append(StringTools.emptyLines(2));
        kelii.appendLine("Gib <weiter> ein, um fortzufahren.");

        renderer.printScreen(kelii);
        handler.waitForAction(new ContinueAction());

        //Intro Rogue Bandito
        Screen bandito = new Screen();
        bandito.append(StringTools.addPadding(Rogue.getGreeting(), 112, 12));
        bandito.append(StringTools.emptyLines(2));
        bandito.append(Rogue.getIcon());
        bandito.append(StringTools.emptyLines(2));
        bandito.append(StringTools.addPadding(Rogue.getDescription(), 112, 12));
        bandito.append(StringTools.emptyLines(2));
        bandito.appendLine("Gib <weiter> ein, um fortzufahren.");

        renderer.printScreen(bandito);
        handler.waitForAction(new ContinueAction());

        //Intro Mermaidman Marin
        Screen marin = new Screen();
        marin.append(StringTools.addPadding(MermaidMan.getGreeting(), 112, 12));
        marin.append(StringTools.emptyLines(2));
        marin.append(MermaidMan.getIcon());
        marin.append(StringTools.emptyLines(1));
        marin.append(StringTools.addPadding(MermaidMan.getDescription(), 112, 12));
        marin.append(StringTools.emptyLines(2));
        marin.appendLine("Gib <weiter> ein, um fortzufahren.");

        renderer.printScreen(marin);
        handler.waitForAction(new ContinueAction());

        //intro World
        ChooseScreen chooseCharacter = new ChooseScreen();
        chooseCharacter.append(new String[]{StringTools.centerInRow("≈≈≈ Wähle deinen Charakter ≈≈≈", 112)});
        chooseCharacter.append(StringTools.emptyLines(2));
        String introWorld = "Du hast verstanden und eine Wahl getroffen? Vergiss nicht: Wähle deine Eigenschaften gut aus, denn der Weg zur Burg kann tückisch sein.";
        chooseCharacter.append(StringTools.addPadding(introWorld, 112, 12));

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

        character.prepareGameOverScreen(new GameOverScreen(this));

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

        for (World w : this.worlds) {
            w.onEnter(this, character);
        }


        //new Screen for last action: win the castle
        String woncastel = "Hurraaaaaa! Du warst mächtig genug um die Monster von Mooscraft zu besiegen. Das Volk ist dir zu ewiger Treue verpflichtet, da du es von den Qualen der Monster Mester und Preisler befreit hast. Damit dein Volk dich gebührend huldigen kann, erklimme mit Hilfe deiner verbliebenen Lebensenergie die Mauern der Burg Arcis Borbetomagus. Nun kannst du ganz Mooscraft überblicken mit seinem grünen Odenwald, der rauschenden Mittelklinge, dem zauberhaften Hexenturm Turismaga. Lass dich als neue/r Herrscher/in von Mooscraft gebührend feiern.";
        String lostcastle = "Oh nein! Die Kämpfe gegen Monster Mester und Preisler haben dir die letzte Lebensenergie geraubt und du stürtzt beim Erklimmen der Burg Arcis Borbetomagus die Wände hinunter in die Tiefe. Doch eine verlorene Schlacht ist kein verlorener Krieg. Wähle deine Parameter weiser und trau dich erneut durch die Pforten von Mooscraft.";

        Screen castle = new Screen();
        if (character.getHealth() >= 25) {
            castle.append(StringTools.addPadding(woncastel, 112, 12));
        } else {
            castle.append(StringTools.addPadding(lostcastle, 112, 12));
        }
        renderer.printScreen(castle);
        String[] castelIcon = new String[]{
                        "                                                      :0Oc.                                         ",
                        "                                                      cNWN0Odoc;'..                                             " +
                        "                                                      cWMMMMMMMWNX0kdl'                                         " +
                        "                                                      cWMMMMMWX0Oxoc;,.                                         " +
                        "                                                      cNN0oc:,..                                                " +
                        "                                                      cX0;                                                      " +
                        "                                        .odl.  :dd;  .OWNx.  :dd;  'ddl.                                        " +
                        "                                        ;XMX; .xMMd  :NMMK, .kMMd  cNMK,                                        " +
                        "                                        ;XMNOdxXMMKxd0WMMNOdkXMMKxd0WM0,                                        " +
                        "                                        ;XMMMMMMMMMMMMMMMMMMMMMMMMMMMMK,                                        " +
                        "                                        ;XMMMMMMMMMMMMMMMMMMMMMMMMMMMMK,                                        " +
                        "                                        'ONNWMMMMMMMMMMMMMMMMMMMMMMWNNx.                                        " +
                        "                                         .',kMMMMMMMMMMMMMMMMMMMMMWd'..                                         " +
                        "                                           .OMMMMMMMMMWWWMMMMMMMMMMx.                                           " +
                        "                                           ;XMMMMMMW0l;,,;oKWMMMMMM0'                                           " +
                        "                                           oMMMMMMMO.      ,0MMMMMMWc                                           " +
                        "                                          .OMMMMMMMx.      .kMMMMMMMx.                                          " +
                        "                                          :NMMMMMMMd       .kMMMMMMMK,                                          " +
                        "                                          dMMMMMMMMd       .kMMMMMMMWl                                          " +
                        "                                         '0MMMMMMMMKdooooooxXMMMMMMMMk.                                         " +
                        "                                         cNMMMMMMMMMMMMMMMMMMMMMMMMMMX;                                         " +
                        "                                        .xMMMMMMMMMMMMMMMMMMMMMMMMMMMWo                                         " +
                        "                                        ,KMMMMMMMMMMMMMMMMMMMMMMMMMMMMO.                                        " +
                        "                                        .oOOOOOOOOOOOOOOOOOOOOOOOOOOOkl.  "
        };
    }

    public Renderer getRenderer() {
        return this.renderer;
    }

    public ActionHandler getHandler() {
        return this.handler;
    }

    public Character getCharacter() {
        return character;
    }
}