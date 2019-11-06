package de.on19.mooscraft.game.worlds.world2;

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
        s.appendLine(StringTools.centerInRow("≈≈≈ Ein mysteriöses Wesen ≈≈≈", 112));
        s.append(StringTools.emptyLines(1));
        String text = "Du begegnest einem groß gebauten schlanken Wesen mit langen hellen Haaren. Ein Elf kommt auf dich zu. Aber keine Angst, Elfen sind friedliche Wesen, er erklärt dir den schnellsten Weg zur Burg, so dass du dich wieder auf den Weg machst. Immer noch voller Hoffnung.";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine(" Du begibst dich wieder auf den Weg. Gib <weiter> ein, um fortzufahren.");

        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {
            System.out.println("exception");

            e.printStackTrace();
        }
        System.out.println("after");
    }

}
