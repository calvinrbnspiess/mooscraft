package de.on19.mooscraft.game.screens;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.interaction.actions.ExitAction;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.TextTools;

public class GameOverScreen extends Screen {
//is implemented in game class and lays in "character". no renderer in character class --> therefore manual implementation
    private Game game;

    public GameOverScreen(Game game) { //created constructor which generates new object game
        this.game = game;

        String[] gameOverOutput = {
                "   ▄██████▄     ▄████████   ▄▄▄▄███▄▄▄▄      ▄████████       ▄██████▄   ▄█    █▄     ▄████████  ▄████████",
                "  ███    ███   ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███      ███    ███ ███    ███   ███    ███  ███    ███",
                "  ███    █▀    ███    ███ ███   ███   ███   ███    █▀       ███    ███ ███    ███   ███    █▀   ███    ███",
                "  ▄███         ███    ███ ███   ███   ███  ▄███▄▄▄          ███    ███ ███    ███  ▄███▄▄▄     ▄███▄▄▄▄██▀",
                "▀▀███ ████▄  ▀███████████ ███   ███   ███▀▀███▀▀▀           ███    ███ ███    ███ ▀▀███▀▀▀     ▀▀███▀▀▀▀▀",
                "  ███    ███   ███    ███ ███   ███   ███   ███    █▄       ███    ███ ███    ███   ███    █▄  ▀███████████",
                "  ███    ███   ███    ███ ███   ███   ███   ███    ███      ███    ███ ███    ███   ███    ███  ███    ███",
                "  ████████▀    ███    █▀   ▀█   ███   █▀    ██████████       ▀██████▀   ▀██████▀    ██████████  ███    ███",
                "                                                                                                ███    ███",
        };

        this.setContent(gameOverOutput); //use method from super class, does not overwrite it: setContent: replaces content completely, append: adds content
        this.append(TextTools.emptyLines(1));
        this.appendLine(TextTools.centerInRow("Du wurdest getötet.", 112));

        this.appendLine(TextTools.centerInRow("Das war wohl nichts " + game.getCharacter().getName() + "! Viel Erfolg bei deinem nächsten Versuch.", 112));
        this.append(TextTools.emptyLines(2));
        this.appendLine("Du kannst das Spiel nun mit <exit> verlassen.");
    }
    //??
    public void print() {
        this.game.getRenderer().printScreen(this); //renderer prints screen, this (is screen)
        //try and catch: try: tests errors in code block; catch: handles errors in code
        //action handler can provide problems --> Try Catch Block
        try {
            game.getHandler().waitForAction(new ExitAction());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
