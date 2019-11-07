package de.on19.mooscraft.renderer;

import de.on19.mooscraft.game.screens.Screen;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.ansi;

public class TerminalRenderer implements Renderer { //what is class implement?

    public TerminalRenderer() {
        AnsiConsole.systemInstall();
    }

    @Override
    public void printScreen(Screen s, boolean erase) {
        if (erase) {
            // ANSI escape codes are used to control cursor location, color, and other options in the terminal
            // by calling ansi().eraseScreen() a special escape code for clearing the screen is generated
            //why do we need this? in Screen and other screens are defined clear methods
            System.out.println(ansi().eraseScreen());
        }
        for (String line : s.getContent()) { //??
            System.out.println(line);
        }
        // print a small indicator signalizing that input is expected
        System.out.print("> ");
    }

    @Override
    public void printScreen(Screen s) {
        this.printScreen(s, true);
    }//??
}
