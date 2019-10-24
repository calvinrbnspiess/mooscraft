package de.on19.mooscraft.game.interaction.actions;

import de.on19.mooscraft.game.interaction.Action;
import de.on19.mooscraft.game.interaction.ActionHandler;

public class ExitAction implements Action {

    @Override
    public void onCommand(String[] args, ActionHandler handler) {
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
