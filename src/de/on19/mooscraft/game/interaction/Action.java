package de.on19.mooscraft.game.interaction;

public interface Action {

    //only called when invoked
    void onCommand(String[] args, ActionHandler handler);

    //should check whether command is invoked. Should not return any exeption when not accepted
    boolean isInvoked(String[] args);

    //should print a helpful description when invoked on a system command
    void onHelp();
}
