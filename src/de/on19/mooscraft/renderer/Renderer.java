package de.on19.mooscraft.renderer;

import de.on19.mooscraft.game.screens.Screen;
//overall creation of a Screen
public interface Renderer {
    /**
     * is the interface class for the Terminal Renderer: tells what is to be done overall
     * specific processes are run in class TerminalRenderer
     */

    void printScreen(Screen s);

    void printScreen(Screen s, boolean erase); //why boolean erase?

}
