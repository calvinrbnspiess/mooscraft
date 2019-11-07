package de.on19.mooscraft.game.interaction;

public interface DescriptedAction extends Action {

    // should return a description for this command which is used in case of showing helpful information
    String getDescription();

    // should return the command which determines isInvoked
    String getAction();

}
