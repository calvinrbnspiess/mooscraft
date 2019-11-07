package de.on19.mooscraft.game.interaction.actions;

import de.on19.mooscraft.game.interaction.Action;
import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.DescriptedAction;
import de.on19.mooscraft.game.screens.Screen;
import de.on19.mooscraft.utils.TextTools;

import java.util.ArrayList;
import java.util.List;

public class HelpAction implements DescriptedAction {

    public static String getActionDescription(DescriptedAction a) {
        return "<" + a.getAction() + "> - " + TextTools.wrapToLength(a.getDescription(), 112);
    }

    public static List<String> getSystemActionDescriptions(ActionHandler handler) {
        List<String> lines = new ArrayList<String>();

        for (DescriptedAction a : handler.getSystemActions()) {
            lines.add(getActionDescription(a));
        }

        return lines;
    }

    @Override
    public void onCommand(String[] args, ActionHandler handler) {
        Screen screen = new Screen();
        screen.append(new String[]{
                TextTools.centerInRow("≈≈≈ Befehlsübersicht ≈≈≈", 112),
                "Folgende Befehle sind definiert. Du kannst diese jederzeit aufrufen:",
        });

        screen.append(TextTools.emptyLines(2));

        screen.append(getSystemActionDescriptions(handler).toArray(new String[0]));

        screen.append(TextTools.emptyLines(2));


        // Print description for awaitedAction

        Action awaitedAction = handler.getAwaitedAction();

        if (awaitedAction instanceof DescriptedAction) {
            screen.append(new String[]{
                    "Im Moment wird folgende Aktion erwartet:",
                    getActionDescription((DescriptedAction) awaitedAction)
            });
        } else {
            screen.appendLine("Im Moment wird keine Aktion erwartet.");
        }

        handler.getRenderer().printScreen(screen, false);
    }

    @Override
    public boolean isInvoked(String[] args) {
        return args[0].equals(this.getAction());
    }

    @Override
    public String getAction() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Zeigt eine Übersicht aller Befehle an.";
    }

}
