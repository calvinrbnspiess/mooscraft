package de.on19.mooscraft.game.worlds.world1;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

public class Spot6 extends Spot {

    public Spot6(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();

        s.appendLine(StringTools.centerInRow("\u001b[1;95m≈≈≈ Du bekommst Besuch auf deinem Weg ≈≈≈", 112));
        s.append(StringTools.emptyLines(2));
        String text = "Ein zartes Wesen schwebt auf dich zu. Du erkennst kleine Fee. Da sie gehört hat wie tapfer du bis hier warst. Schenkt sie dir Stärke";
        s.append(StringTools.addPadding(text, 112, 12));
        s.append(StringTools.emptyLines(1));
        s.appendLine("Du bekommst 10 Einheiten Stärke. Gib <weiter> ein, um fortzufahren.");

        character.addStrength(10);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
