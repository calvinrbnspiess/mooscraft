package de.on19.mooscraft.game.worlds.world4;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.screens.Screen;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.utils.TextTools;

public class Spot2 extends Spot {

    public Spot2(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(TextTools.centerInRow("≈≈≈ Entdeckung einer Höhle ≈≈≈", 112));
        s.append(TextTools.emptyLines(1));
        String text = "Du stößt auf eine Höhle voller Edelsteine, Juwelen und anderen Kostbarkeiten. Mitten in all den wertvollen Gegenständen Truhe des Alchemisten.";
        s.append(TextTools.addPadding(text, 112, 12));
        s.append(TextTools.emptyLines(1));

        s.appendLine(TextTools.wrapToLength("Du öffnest die Truhe und erhälst dadurch 10 Einheiten an Weisheit.", 112));
        s.appendLine("Gib <weiter> ein, um fortzufahren.");

        character.addWisdom(10);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
