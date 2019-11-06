package de.on19.mooscraft.game.screens;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.interaction.actions.ExitAction;
import de.on19.mooscraft.renderer.Renderer;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

public class GameOverScreen extends Screen {

    private Game game;

    public GameOverScreen(Game game) {
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

        this.setContent(gameOverOutput);
        super.append(StringTools.emptyLines(1));
        this.appendLine(StringTools.centerInRow("Du wurdest getötet.", 112));

        this.appendLine(StringTools.centerInRow("Das war wohl nichts " + game.getCharacter().getName() + "! Viel Erfolg bei deinem nächsten Versuch.", 112));
        this.append(StringTools.emptyLines(2));
        this.appendLine("Du kannst das Spiel nun mit <exit> verlassen.");
    }

    public void print() {
        this.game.getRenderer().printScreen(this);

        try {
            game.getHandler().waitForAction(new ExitAction());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}