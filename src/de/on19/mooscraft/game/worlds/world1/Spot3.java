package de.on19.mooscraft.game.worlds.world1;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

public class Spot3 extends Spot {

    public Spot3(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(StringTools.centerInRow("≈≈≈ Tief im Odenwald ≈≈≈", 112));
        s.append(StringTools.emptyLines(1));
        s.appendLine(game.getProgressIndicator(character));
        s.append(StringTools.emptyLines(2));
        String text = "Die Seherin sagt dir deine Zukunft voraus, dafür musst du ihr leider etwas deiner Stärke abgeben. Deine Prophezeiung lautet: “Ich sehe Dunkles kommen. Um deinem Untergang zu entkommen, brauchst du jenes, welches dir Kraft schenkt.” ";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Du gibst 5 Einheiten deiner Stärke ab und gehst verwirrt weiter. Gib <weiter> ein, um fortzufahren.");

        game.getRenderer().printScreen(s, true);
        character.addStrength(-5);
        /*z.B. health zufügen
         * character.addhealth(parameter eingeben)
         */
        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {
            System.out.println("exception");

            e.printStackTrace();
        }
        System.out.println("after");
    }

}
