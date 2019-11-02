package de.on19.mooscraft.game.interaction.actions;

import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.SystemAction;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

import java.util.ArrayList;
import java.util.List;

public class HelpAction implements SystemAction {

    // TODO Should include GameAction that is waited for?

    public static List<String> getSystemActionDescriptions(ActionHandler handler) {
        List<String> lines = new ArrayList<String>();

        for(SystemAction a : handler.getSystemActions()) {
            lines.add("<" + a.getAction() + "> - " + StringTools.wrapToLength(a.getDescription(), 112));
        }

        return lines;
    }

    @Override
    public void onCommand(String[] args, ActionHandler handler) {
        System.out.println("hope this motivational message helps!");

        Screen screen = new Screen();
        screen.append(new String[]{
              StringTools.centerInRow("≈≈≈ Befehlsübersicht ≈≈≈", 112),
              "Folgende Befehle sind definiert. Du kannst diese jederzeit aufrufen:",
        });

        screen.append(StringTools.emptyLines(2));

        screen.append(getSystemActionDescriptions(handler).toArray(new String[0]));

        handler.getRenderer().printScreen(screen, false);
    }

    @Override
    public boolean isInvoked(String[] args) {
        return args[0].equals("help");
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
