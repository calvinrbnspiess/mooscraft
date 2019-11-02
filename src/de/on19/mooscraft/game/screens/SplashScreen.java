package de.on19.mooscraft.game.screens;

import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.actions.HelpAction;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

public class SplashScreen extends Screen {
    /**three different screen classes since every one got different structure
     * ChooseScreen: with choice options
     * ScoreboardScreen: only displays
     * Splashscreen: displays in the beginning
     */

    public SplashScreen(ActionHandler handler) {
        super();

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
        super.append(StringTools.emptyLines(1));

        String introduction = "Es war einmal eine Welt vor der unseren, beherrscht von Ungeheuern, Zauberern und Zauberinnen und Wasserwesen. Sie alle kämpften mit den unterschiedlichsten Kräften um die Eroberung der Burg. Doch Vorsicht war geboten, denn viele Fallen und Feinde lauerten in den dunkelsten Ecken und den tiefsten Verstecken um sie daran zu hindern. Viel Energie, Kraft und Stärke war gefordert um die Welt zu durchlaufen und mit genügend Kräften ans Ziel zu kommen. Egal ob Hexe, Kriegerin, Magier, Schurke oder Meerjungfraumann, sie alle machten sich auf den Weg zur Burg, denn es kann nur einen Herrscher über die Welt geben.";

        super.append(StringTools.addPadding(introduction, 112, 12));
        super.append(StringTools.emptyLines(2));
        super.append(new String[]{StringTools.centerInRow("≈≈≈ So lasset die Reise beginnen ≈≈≈", 112)});
        super.append(StringTools.emptyLines(2));
        super.appendLine("Verfügbare Befehle:");
        super.append(HelpAction.getSystemActionDescriptions(handler).toArray(new String[0]));
        super.append(StringTools.emptyLines(2));
        super.appendLine("Du hast alles verstanden? Dann gib zum Fortfahren bitte <weiter> ein.");
    }

}
