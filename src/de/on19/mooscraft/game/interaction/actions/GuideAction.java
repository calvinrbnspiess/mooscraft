package de.on19.mooscraft.game.interaction.actions;

import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.DescriptedAction;
import de.on19.mooscraft.game.screens.Screen;
import de.on19.mooscraft.utils.TextTools;

import java.util.ArrayList;
import java.util.List;

public class GuideAction implements DescriptedAction {

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
                TextTools.centerInRow("≈≈≈ Spielanleitung≈≈≈", 112),
        });

        String instructions = "Mooscraft besteht aus 4 Welten welche du alle überleben musst um die Burg am Ende des Spieles erobern zu können. Ziel der Mission ist es am Ende noch so viel wie möglich Lebensenergie zu haben. Ausschlaggebende Faktoren hierfür sind Erstens die Wahl deines Spielchrakteres und Zweitens für welchen Weg du dich entscheidest. Am Startpunkt jeder der vier Welten musst du dich an einer Weggabelung für Option A oder B entscheiden, je nachdem hast du dann einen Weg durch die Welt gefunden der dir mehr oder weniger Kräfte raubt. Wenn du die richtigen Entscheidungen triffst steht deiner Herrschaft über Mooscraft nichts mehr im Wege.";

        screen.append(TextTools.addPadding(instructions, 112, 12));
        screen.append(TextTools.emptyLines(2));
        screen.append(getIcon());


        handler.getRenderer().printScreen(screen, false);

    }

    public String[] getIcon() {
        String[] instructionsIcon = new String[]{"            _______                     _______                     _______                    _______",
                "            |Feld2|                     |Feld2|                     |Feld2|                    |Feld2|",
                "     _______       _______       _______       _______       _______       _______      _______       _______",
                "     |Feld1|       |Feld3|       |Feld1|       |Feld3|       |Feld1|       |Feld3|      |Feld1|       |Feld3|",
                "______                     ______                     ______                     ______",
                "|  A |                     |  A |                     |  A |                     |  A |                     ----",
                "|oder|        WELT 1       |oder|        WELT 2       |oder|        WELT 3       |oder|         WELT4       ZIEL",
                "|  B |                     |  B |                     |  B |                     |  B |                     ----",
                "     _______       _______       _______       _______       _______       _______      _______       _______",
                "     |Feld1|       |Feld3|       |Feld1|       |Feld3|       |Feld1|       |Feld3|      |Feld1|       |Feld3|",
                "            _______                     _______                     _______                    _______",
                "            |Feld2|                     |Feld2|                     |Feld2|                    |Feld2|"};
        return instructionsIcon;
    }

    @Override
    public boolean isInvoked(String[] args) {
        return args[0].equals(this.getAction());
    }

    @Override
    public String getAction() {
        return "guide";
    }

    @Override
    public String getDescription() {
        return "Zeigt eine Spielanleitung an.";
    }

}
