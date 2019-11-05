package de.on19.mooscraft.game.worlds.world4;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

public class Spot2 extends Spot {

    public Spot2(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(StringTools.centerInRow("≈≈≈ Entdeckung einer Höhle ≈≈≈", 112));
        s.append(StringTools.emptyLines(1));
        s.appendLine(game.getProgressIndicator(character));
        s.append(StringTools.emptyLines(2));
        String text = "Du stößt auf eine Höhle voller Edelsteine, Juwelen und anderen Kostbarkeiten. Mitten in all den wertvollen Gegenständen Truhe des Alchemisten.";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Du öffnest die Truhe und erhälst dadurch 10 Einheiten an Weisheit. Gib <weiter> ein, um fortzufahren.");

        game.getRenderer().printScreen(s, true);
        character.addWisdom(10);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {
            System.out.println("exception");

            e.printStackTrace();
        }
        System.out.println("after");
    }

}
