package de.on19.mooscraft.game.interaction;

import de.on19.mooscraft.game.interaction.actions.GameAction;
import de.on19.mooscraft.renderer.Renderer;
import de.on19.mooscraft.utils.StringTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TerminalActionHandler implements ActionHandler {

    private Scanner scanner;
    private List<Action> systemActions;
    // used to synchronize parallel tasks
    private Object notifier;
    private Action awaitedAction;
    private Renderer renderer;

    public TerminalActionHandler(Renderer renderer) {
        this.renderer = renderer;
        this.systemActions = new ArrayList<Action>();
        this.scanner = new Scanner(System.in);
        this.notifier = new Object();

        this.systemActions.add(new GameAction() {
            @Override
            public void onCommand(String[] args, ActionHandler handler) {
                System.out.println("hope this motivational message helps!");
                System.out.println(Arrays.toString(args));
            }

            @Override
            public boolean isInvoked(String[] args) {
                return args[0].equals("help");
            }
        });

        // create new parallel task that listens for user interaction with the terminal
        new Thread(() -> {
            while (scanner.hasNext()) {
                String[] args = scanner.next().split(StringTools.MATCH_WHITESPACE);

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

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }
}
