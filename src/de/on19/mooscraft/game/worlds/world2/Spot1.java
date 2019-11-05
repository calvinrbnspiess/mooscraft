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
        s.appendLine(StringTools.centerInRow("≈≈≈ Tief im Odenwald ≈≈≈", 112));
        s.append(StringTools.emptyLines(1));
        s.appendLine(game.getProgressIndicator(character));
        s.append(StringTools.emptyLines(2));
        String text = "Nahe am Wasser da lebts sich gut. Albert seine Anpflanzungen wachsen und gedeihen in dem fruchtbaren Boden. Schmackhaft und lecker sehen diese aus, manche schenken dir beim Vernaschen, extra Stärke, Willenskraft oder Lebensenergie. Doch andere hingegen, ziehen dir gegenteilig dazu einiges davon ab, so dass du am Ende deiner Kräfte bist.";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Du probierst eine blau leuchtende Blume und verlierst 5 Einheiten Willenskraft. Gib <weiter> ein, um fortzufahren.");

        game.getRenderer().printScreen(s, true);
        //character.addHealth(10);
        /*extra Stärke, Willenskraft oder Lebensenergie (jeweils +10) ?
        (Stärke, Lebensenergie oder Willenskraft -5, per Zufall?)
           z.B. health zufügen
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
