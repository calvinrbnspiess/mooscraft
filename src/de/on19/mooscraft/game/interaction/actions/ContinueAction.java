package de.on19.mooscraft.game.interaction.actions;

import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.DescriptedAction;

public class ContinueAction implements DescriptedAction {

    @Override
    public String getDescription() {
        return "Bitte gib 'weiter' ein, um mit dem Spiel fortzufahren.";
    }

    @Override
    public String getAction() {
        return "weiter";
    }

    @Override
    public void onCommand(String[] args, ActionHandler handler) {
        // do nothing
    }

    @Override
    public boolean isInvoked(String[] args) {
        return args[0].equals(this.getAction());
    }

}
