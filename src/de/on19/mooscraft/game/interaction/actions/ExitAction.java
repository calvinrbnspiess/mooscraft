package de.on19.mooscraft.game.interaction.actions;

import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.DescriptedAction;
import de.on19.mooscraft.game.screens.Screen;

public class ExitAction implements DescriptedAction {

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
        return args[0].equals(this.getAction());
    }

    @Override
    public String getAction() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Beendet Mooscraft.";
    }

}
