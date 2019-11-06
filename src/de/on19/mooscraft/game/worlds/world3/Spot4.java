package de.on19.mooscraft.game.worlds.world3;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.TextTools;

public class Spot4 extends Spot {

    public Spot4(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(TextTools.centerInRow("≈≈≈ ein Hexenturm ≈≈≈", 112));
        s.append(TextTools.emptyLines(1));
        String text = "Am Eingang des Hexenturmes wartet ein sprechender Rabe als Komplizin der Hausherrin auf dich. Er verlangt als Wegzoll einer deiner kostbaren Zaubertränke.";
        s.append(TextTools.addPadding(text, 112, 12));
        s.appendLine("Somit verlierst du 10 Einheiten an Zauberkraft. Gib <weiter> ein, um fortzufahren.");

        character.addWitchcraft(-10);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
