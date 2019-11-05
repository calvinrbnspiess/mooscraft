package de.on19.mooscraft.game.worlds.world2;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

public class Spot4 extends Spot {

    public Spot4(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(StringTools.centerInRow("≈≈≈ Tief im Odenwald ≈≈≈", 112));
        s.append(StringTools.emptyLines(1));
        s.append(game.getStatsIndicator(character));
        s.append(StringTools.emptyLines(2));
        String text = "Du kommst auf einen rauschenden Wasserfall zu. Dort holst du dir eine kleine Erfrischung und trinkst einen kleinen Schluck Wasser und holst dir dadurch etwas mehr Lebensenergie.";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Deinen Durst hast du nun gelöscht und nun wieder 5 Einheiten mehr an Lebensenergie. Gib <weiter> ein, um fortzufahren.");

        game.printGameScreen(s);
        character.addHealth(5);
        

        /*           z.B. health zufügen
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
