package de.on19.mooscraft;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.TerminalActionHandler;
import de.on19.mooscraft.renderer.Renderer;
import de.on19.mooscraft.renderer.TerminalRenderer;

public class Main {
    
    public static void main(String[] args) {
        Renderer renderer = new TerminalRenderer();
        ActionHandler handler = new TerminalActionHandler(renderer);

        Game game = new Game(renderer, handler);

        try {
            game.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
