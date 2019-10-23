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
            System.out.println(ansi().eraseScreen());
        }
        for (String line : s.getContent()) {
            System.out.println(line);
        }
    }

    @Override
    public void printScreen(Screen s) {
        this.printScreen(s, true);
    }
}
