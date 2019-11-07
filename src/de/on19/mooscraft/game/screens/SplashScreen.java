package de.on19.mooscraft.game.screens;

import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.actions.HelpAction;
import de.on19.mooscraft.utils.TextTools;

public class SplashScreen extends Screen {


    public SplashScreen(ActionHandler handler) { //why does it refer to ActionHandler and handler?
        super(); //??
        //difference String(), String[]
        String[] content = {
                "   ▄▄▄▄███▄▄▄▄    ▄██████▄   ▄██████▄     ▄████████  ▄████████    ▄████████    ▄████████    ▄████████     ███ ",
                " ▄██▀▀▀███▀▀▀██▄ ███    ███ ███    ███   ███    ███ ███    ███   ███    ███   ███    ███   ███    ███ ▀█████████▄",
                " ███   ███   ███ ███    ███ ███    ███   ███    █▀  ███    █▀    ███    ███   ███    ███   ███    █▀     ▀███▀▀██",
                " ███   ███   ███ ███    ███ ███    ███   ███        ███         ▄███▄▄▄▄██▀   ███    ███  ▄███▄▄▄         ███   ▀",
                " ███   ███   ███ ███    ███ ███    ███ ▀███████████ ███        ▀▀███▀▀▀▀▀   ▀███████████ ▀▀███▀▀▀         ███    ",
                " ███   ███   ███ ███    ███ ███    ███          ███ ███    █▄  ▀███████████   ███    ███   ███            ███    ",
                " ███   ███   ███ ███    ███ ███    ███    ▄█    ███ ███    ███   ███    ███   ███    ███   ███            ███    ",
                "  ▀█   ███   █▀   ▀██████▀   ▀██████▀   ▄████████▀  ████████▀    ███    ███   ███    █▀    ███           ▄████▀  ",
                "                                                                 ███    ███                                      "};
        super.setContent(content);
        super.append(TextTools.emptyLines(1));

        //introduction game
        String introduction = "Es war einmal eine Welt vor der unseren, beherrscht von Ungeheuern, Zauberern und Zauberinnen und Wasserwesen. Sie alle kämpfen mit den unterschiedlichsten Kräften um die Eroberung der Burg. Doch Vorsicht ist geboten, denn viele Fallen und Feinde lauern in den dunkelsten Ecken und tiefsten Verstecken. Viel Energie, Kraft und Stärke ist gefordert um die Welt zu durchlaufen und mit genügend Kräften ans Ziel zu kommen. Egal ob Hexe, Kriegerin, Magier, Schurke oder Meerjungfraumann, sie alle machen sich auf den Weg zur Burg, denn es kann nur einen Herrscher oder eine Herrscherin über die Welt geben.";
        super.append(TextTools.addPadding(introduction, 112, 12));
        super.append(TextTools.emptyLines(2));

        //begin journey
        super.append(new String[]{TextTools.centerInRow("≈≈≈ \u001b[1;36mSo lasset die Reise beginnen\u001b[0m ≈≈≈", 112)});
        super.append(TextTools.emptyLines(2));

        //possible commands
        super.appendLine("Verfügbare Befehle:");
        super.append(HelpAction.getSystemActionDescriptions(handler).toArray(new String[0]));
        super.append(TextTools.emptyLines(2));


        super.appendLine("Du hast alles verstanden? Dann gib zum Fortfahren bitte <weiter> ein."); //s?
    }

}
