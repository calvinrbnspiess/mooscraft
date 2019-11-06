package de.on19.mooscraft.game.interaction.actions;

import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.DescriptedAction;
import de.on19.mooscraft.game.screens.ChooseScreen;

public class ChooseAction implements DescriptedAction {

    private ChooseScreen screen;
    private String choosenOption;

    public ChooseAction(ChooseScreen chooseScreen) {
        this.screen = chooseScreen;
        this.choosenOption = null;
    }

    @Override
    public String getDescription() {
        return "Wähle eine der dargestellten Optionen. Die Eingabe soll der Aktion eindeutig zugeordnet werden können.";
    }

    @Override
    public String getAction() {
        return "?";
    }

    @Override
    public void onCommand(String[] args, ActionHandler handler) {
        String[] options = screen.getFormattedOptions();

        for (String option : options) {
            // continue search if option is not matching
            if (!option.toLowerCase().contains(String.join(" ", args).toLowerCase()))
                continue;

            // option is matching, but what if an option was already chosen? -> unset chosenOption
            if (this.choosenOption != null) {
                this.choosenOption = null;
                return;
            }

            this.choosenOption = option;
        }
    }

    public String getChosenOption() {
        return this.choosenOption;
    }

    @Override
    public boolean isInvoked(String[] args) {
        return true;
    }

}
