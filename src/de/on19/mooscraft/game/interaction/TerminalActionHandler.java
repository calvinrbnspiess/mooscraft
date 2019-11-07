package de.on19.mooscraft.game.interaction;

import de.on19.mooscraft.game.interaction.actions.ExitAction;
import de.on19.mooscraft.game.interaction.actions.GuideAction;
import de.on19.mooscraft.game.interaction.actions.HelpAction;
import de.on19.mooscraft.renderer.Renderer;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.TextTools;

import java.util.List;
import java.util.Scanner;

public class TerminalActionHandler implements ActionHandler {

    private static List<DescriptedAction> systemActions = List.of(new HelpAction(), new GuideAction(), new ExitAction());
    private Scanner scanner;
    // used to synchronize parallel tasks
    private Object notifier;
    private Action awaitedAction;
    private Renderer renderer;

    public TerminalActionHandler(Renderer renderer) {
        this.renderer = renderer;
        this.scanner = new Scanner(System.in);
        this.notifier = new Object();

        // create new parallel task that listens for user interaction with the terminal
        new Thread(() -> {
            while (scanner.hasNext()) {
                String[] args = scanner.next().split(TextTools.MATCH_WHITESPACE);

                boolean wasInvoked = false;
                // check if any systemAction should be invoked - they have priority
                for (Action action : systemActions) {
                    if (action.isInvoked(args)) {
                        wasInvoked = true;
                        action.onCommand(args, this);
                        break;
                    }
                }

                // used to synchronize the parallel tasks
                synchronized (notifier) {
                    if (wasInvoked || awaitedAction == null) {
                        continue;
                    }

                    if (awaitedAction.isInvoked(args)) {
                        awaitedAction.onCommand(args, this);
                        // reactivate other task
                        awaitedAction = null;
                        notifier.notify();
                    } else {
                        // no action was recognized

                        Screen screen = new Screen();
                        screen.appendLine("Es konnte keine Aktion erkannt werden. Du weißt nicht weiter? Rufe mit <help> die Hilfestellung auf.");
                        // maybe it is not a good idea to erase the screen when our user doesn't know what he is doing. - so no erase here
                        renderer.printScreen(screen, false);
                    }
                }
            }
        }).start();
    }

    @Override
    public void waitForAction(Action action) throws InterruptedException {
        this.awaitedAction = action;

        synchronized (notifier) {
            // sleep until action was invoked
            while (this.awaitedAction != null) {
                notifier.wait();
            }
            return;
        }
    }

    @Override
    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public List<DescriptedAction> getSystemActions() {
        return systemActions;
    }

    @Override
    public Action getAwaitedAction() {
        return this.awaitedAction;
    }

}
