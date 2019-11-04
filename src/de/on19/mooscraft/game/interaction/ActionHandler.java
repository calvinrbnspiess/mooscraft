package de.on19.mooscraft.game.interaction;

import de.on19.mooscraft.renderer.Renderer;

import java.util.List;

public interface ActionHandler {

    void waitForAction(Action a) throws InterruptedException;

    Renderer getRenderer();

    List<DescriptedAction> getSystemActions();

    Action getAwaitedAction();
}
