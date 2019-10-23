package de.on19.mooscraft.game;

import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.actions.GameAction;
import de.on19.mooscraft.game.screens.ChooseScreen;
import de.on19.mooscraft.game.screens.SplashScreen;
import de.on19.mooscraft.renderer.Renderer;
import de.on19.mooscraft.utils.StringTools;

public class Game {

    private Renderer renderer;
    private ActionHandler handler;

    public Game(Renderer renderer, ActionHandler handler) {
        this.renderer = renderer;
        this.handler = handler;
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
    }

}
