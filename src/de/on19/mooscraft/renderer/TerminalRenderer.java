package de.on19.mooscraft.renderer;

import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.ansi;

public class TerminalRenderer implements Renderer {

    public TerminalRenderer() {
        AnsiConsole.systemInstall();
    }

    @Override
    public void printScreen(Screen s, boolean erase) {
        if (erase) {
            // ANSI escape codes are used to control cursor location, color, and other options in the terminal
            // by calling ansi().eraseScreen() a special escape code for clearing the screen is generated
            System.out.println(ansi().eraseScreen());
        }
        for (String line : s.getContent()) {
            System.out.println(line);
        }
        // print a small indicator signalizing that input is expected
        System.out.print("> ");
    }

    @Override
    public void printScreen(Screen s) {
        this.printScreen(s, true);
    }
}
