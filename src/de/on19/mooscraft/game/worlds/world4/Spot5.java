package de.on19.mooscraft.game.worlds.world4;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

public class Spot5 extends Spot {

    public Spot5(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(StringTools.centerInRow("≈≈≈ Tief im Odenwald ≈≈≈", 112));
        s.append(StringTools.emptyLines(1));
        String text = "Es ist Mittlerweile Nacht geworden und du siehst nicht mehr wirklich ob du dich noch auf dem Weg befindest. Unvorhersehbar versinkst versehentlich bis zur Brust im Mooscraft-Moor, mit Hilfe es eines Zaubertrankes kannst du dich gerade noch so hinaus retten.";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Doch das kostet dich 10 Einheiten an Zauberkraft. Gib <weiter> ein, um fortzufahren.");

        game.printGameScreen(s);
        character.addWitchcraft(-10);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {
            System.out.println("exception");

            e.printStackTrace();
        }
        System.out.println("after");
    }

}
