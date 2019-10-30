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
import de.on19.mooscraft.renderer.Renderer;
import de.on19.mooscraft.utils.StringTools;

public class Game {

    private Renderer renderer;
    private ActionHandler handler;
    private Character character;

    public Game(Renderer renderer, ActionHandler handler) {
        this.renderer = renderer;
        this.handler = handler;
        this.character = null;
    }

    public void run() throws InterruptedException {
        renderer.printScreen(new SplashScreen());

        handler.waitForAction(new GameAction() {
            @Override
            public boolean isInvoked(String[] args) {
                return args[0].equals("weiter");
            }
        });

        ChooseScreen chooseCharacter = new ChooseScreen();

        chooseCharacter.append(new String[]{StringTools.centerInRow("≈≈≈ Wähle deinen Charakter ≈≈≈", 112)});

        chooseCharacter.addOptions(new String[]{
                "Magalia (Hexe)",
                "Bellatrix (Kriegerin)",
                "Weißer Magier",
                "Schurke",
                "Meerjungfraumann"
        });
        chooseCharacter.addInstruction("Triff eine weise Entscheidung, indem du eine der Optionen eingibst.");

        renderer.printScreen(chooseCharacter, true);

        handler.waitForAction(new GameAction() {

            @Override
            public void onCommand(String[] args, ActionHandler handler) {
                String chosen = args[0].toLowerCase();
                ;
                if (chooseCharacter.getFormattedOptions()[0].toLowerCase().contains(chosen)) {
                    character = new Witch();
                } else if (chooseCharacter.getFormattedOptions()[1].toLowerCase().contains(chosen)) {
                    character = new Warrior();
                } else if (chooseCharacter.getFormattedOptions()[2].toLowerCase().contains(chosen)) {
                    character = new WhiteMage();
                } else if (chooseCharacter.getFormattedOptions()[3].toLowerCase().contains(chosen)) {
                    character = new Rogue();
                } else if (chooseCharacter.getFormattedOptions()[4].toLowerCase().contains(chosen)) {
                    character = new MermaidMan();
                }
            }

            @Override
            public boolean isInvoked(String[] args) {
                return true;
            }
        });
    }

}
