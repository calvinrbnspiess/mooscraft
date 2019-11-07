package de.on19.mooscraft.game.worlds.world1;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.game.screens.Screen;
import de.on19.mooscraft.utils.TextTools;

public class Spot3 extends Spot {

    public Spot3(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();

        s.appendLine(TextTools.centerInRow("\u001b[1;95m≈≈≈ In einem Zelt im Odenwald ≈≈≈", 112));
        s.append(TextTools.emptyLines(2));
        String text = "Die Seherin sagt dir deine Zukunft voraus. Dafür musst du ihr leider etwas deiner Stärke abgeben. Deine Prophezeiung lautet: “Ich sehe Dunkles kommen. Um deinem Untergang zu entkommen brauchst du jenes, welches dir Kraft schenkt.” ";
        s.append(TextTools.addPadding(text, 112, 12));
        s.append(TextTools.emptyLines(1));
        s.appendLine(TextTools.wrapToLength("Du verlierst 5 Einheiten an Stärke und gehst verwirrt weiter.", 112));
        s.appendLine("Gib <weiter> ein, um fortzufahren.");

        character.addStrength(-5);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
