package de.on19.mooscraft.game.worlds.world2;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

public class Spot1 extends Spot {

    public Spot1(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(StringTools.centerInRow("≈≈≈ Am Fluss Mittelklinge ≈≈≈", 112));
        s.append(StringTools.emptyLines(1));

        String text = "Nahe am Wasser da lebts sich gut. Albert seine Anpflanzungen wachsen und gedeihen in dem fruchtbaren Boden. Schmackhaft und lecker sehen diese aus, manche schenken dir beim Vernaschen, extra Stärke, Willenskraft oder Lebensenergie. Doch andere hingegen, ziehen dir einiges davon ab.";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Du probierst eine blau leuchtende Blume und verlierst 5 Einheiten Willenskraft. Gib <weiter> ein, um fortzufahren.");

        character.addWillpower(-5);
        game.printGameScreen(s);

        //character.addHealth(10);
        /*extra Stärke, Willenskraft oder Lebensenergie (jeweils +10) ?
        (Stärke, Lebensenergie oder Willenskraft -5, per Zufall?)
           z.B. health zufügen
         * character.addhealth(parameter eingeben)
         */

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
