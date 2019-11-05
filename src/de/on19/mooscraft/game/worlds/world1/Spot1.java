package de.on19.mooscraft.game.worlds.world1;

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
        String text = "Mester lebt tief im Odenwald, alleine und mit einem kleinen Drachen “Exernius”. Begegnest du seiner vermoosten Hütte, gib acht! Denn die Nähe eines Eindringlings zu seinem Heim weckt Exernius und löst einen Stromkreis aus, aus welchem du nicht entfliehen kannst bis du Exernius besiegt hast, oder er dich.";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Du wirst den Kampf aufnehmen. Gib <weiter> ein, um fortzufahren.");

        game.getRenderer().printScreen(s, true);
        character.addHealth(-5);
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


   /* Screen spot1 = new Screen();
        String spot1won = "Gewonnen";
        String spot1lost = "Verloren";
        if (character.getHealth() >= 25) {
        spot1.append(StringTools.addPadding(spot1won, 112, 12));
    } else {
        spot1.append(StringTools.addPadding(spot1lost, 112, 12));
    }
        renderer.printScreen(spot1);
}*/

}
