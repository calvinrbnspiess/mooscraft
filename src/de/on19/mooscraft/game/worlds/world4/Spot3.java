package de.on19.mooscraft.game.worlds.world4;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.TextTools;

public class Spot3 extends Spot {

    public Spot3(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(TextTools.centerInRow("≈≈≈ ein Gnom ≈≈≈", 112));
        s.append(TextTools.emptyLines(1));
        String text = "Du wirst von einem Gnom auf fiese Art und Weise ausgetrickst er hat es geschafft dir dein Geld aus der Tasche zu ziehen.";
        s.append(TextTools.addPadding(text, 112, 12));
        s.appendLine("Seine hinterlistige Art kostet dich 20 Einheiten Willenskraft. Gib <weiter> ein, um fortzufahren.");

        character.addWillpower(-20);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
