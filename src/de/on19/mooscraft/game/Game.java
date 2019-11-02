package de.on19.mooscraft.game;

import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.characters.MermaidMan;
import de.on19.mooscraft.game.characters.Rogue;
import de.on19.mooscraft.game.characters.Witch;
import de.on19.mooscraft.game.characters.Warrior;
import de.on19.mooscraft.game.characters.WhiteMage;
import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.actions.GameAction;
import de.on19.mooscraft.game.screens.ChooseScreen;
import de.on19.mooscraft.game.screens.SplashScreen;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.game.worlds.world1.World1;
import de.on19.mooscraft.renderer.Renderer;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;   // allall

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
        this.worlds = List.of(new World1(), new World1());
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
        renderer.printScreen(new SplashScreen(handler));
            //shows start screen

        handler.waitForAction(new GameAction() {
            @Override
            public boolean isInvoked(String[] args) {
                return args[0].equals("weiter");
            }
        });
            /**waits for any interaction by typing "weiter" into keyboard
            if no action or other actions follows --> see method onCommand
             */

        ChooseScreen chooseCharacter = new ChooseScreen();

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
