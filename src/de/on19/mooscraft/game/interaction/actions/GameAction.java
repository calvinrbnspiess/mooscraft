package de.on19.mooscraft.game.interaction.actions;

import de.on19.mooscraft.game.interaction.Action;
import de.on19.mooscraft.game.interaction.ActionHandler;

public abstract class GameAction implements Action {

    @Override
    public boolean isInvoked(String[] args) {
        return true;
    }

    @Override
    public void onCommand(String[] args, ActionHandler handler) {
        // do nothing when not overwritten
    }

}
