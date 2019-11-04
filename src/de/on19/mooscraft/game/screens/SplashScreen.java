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
        String instructionHead = "\u001b[1;91mSpielanleitung\u001b[0m";
        super.append(StringTools.addPadding(instructionHead, 112, 12));
        String instructions = "Mooscraft besteht aus 4 Welten welche du alle überleben musst um die Burg am " +
                "Ende des Spieles erobern zu können. Ziel der Mission ist es am Ende noch so viel wie möglich Lebensenergie zu haben. Ausschlaggebende Faktoren hierfür sind Erstens die Wahl deines Spielchrakteres und Zweitens für welchen Weg du dich entscheidest. Am Startpunkt jeder der vier Welten musst du dich an einer Weggabelung für Option A oder B entscheiden, je nachdem hast du dann einen Weg durch die Welt gefunden der dir mehr oder weniger Kräfte raubt. Wenn du die richtigen Entscheidungen triffst steht deiner Herrschaft über Mooscraft nichts mehr im Wege.";
        super.append(StringTools.addPadding(instructions, 112, 12));
        super.appendLine("Du hast alles verstanden? Dann gib zum Fortfahren bitte <weiter> ein.");
    }

}
