package de.on19.mooscraft.game.interaction.actions;

import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.DescriptedAction;

public class SkippableContinueAction implements DescriptedAction {


    private boolean wasSkipped = false;
    private String description;

    public SkippableContinueAction(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getAction() {
        return "weiter";
    }

    @Override
    public void onCommand(String[] args, ActionHandler handler) {
        if (args[0].equals("überspringen")) {
            this.wasSkipped = true;
        }
    }

    @Override
    public boolean isInvoked(String[] args) {
        return args[0].equals(this.getAction()) || args[0].equals("überspringen");
    }

    public boolean isSkipped() {
        return this.wasSkipped;
    }
}
