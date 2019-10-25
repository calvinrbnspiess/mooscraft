package de.on19.mooscraft.game.interaction.actions;

import de.on19.mooscraft.game.interaction.Action;
import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.renderer.Screen;

public class ExitAction implements Action {

    @Override
    public void onCommand(String[] args, ActionHandler handler) {
        Screen screen = new Screen();
        screen.appendLine("Gehabt Euch wohl. Bis zum nächsten Spiel.");
        // maybe it is not a good idea to erase the screen when our user doesn't know what he is doing. - so no erase here
        handler.getRenderer().printScreen(screen, false);
        System.exit(0);
    }

    @Override
    public boolean isInvoked(String[] args) {
        return args[0].equals("exit");
    }

    @Override
    public void onHelp() {
        //here should be a help
        //how to implement?
    }
}
