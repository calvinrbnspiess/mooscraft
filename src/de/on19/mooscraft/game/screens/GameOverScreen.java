package de.on19.mooscraft.game.screens;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.interaction.actions.ExitAction;
import de.on19.mooscraft.utils.TextTools;

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

        super.setContent(gameOverOutput); //how does set content here??
        super.append(TextTools.emptyLines(1)); //super??
        super.appendLine(TextTools.centerInRow("Du wurdest getötet.", 112));
        super.append(TextTools.emptyLines(1));
        super.appendLine(TextTools.centerInRow("Das war wohl nichts '" + game.getCharacter().getName() + "'! Viel Erfolg bei deinem nächsten Versuch.", 112));
        super.append(TextTools.emptyLines(2));
        super.appendLine("Du kannst das Spiel nun mit <exit> verlassen.");
    }
    //??
    public void print() {
        this.game.getRenderer().printScreen(this); //s:this ??
        //try and catch: try: tests errors in code block; catch: handles errors in code
        try {
            game.getHandler().waitForAction(new ExitAction());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
