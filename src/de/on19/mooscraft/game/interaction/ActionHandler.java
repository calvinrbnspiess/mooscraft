package de.on19.mooscraft.game.interaction;

public interface ActionHandler {

    void waitForAction(Action a) throws InterruptedException;

}
