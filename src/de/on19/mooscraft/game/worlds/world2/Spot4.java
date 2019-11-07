package de.on19.mooscraft.game.worlds.world2;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.screens.Screen;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.utils.TextTools;

public class Spot4 extends Spot {

    public Spot4(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(TextTools.centerInRow("\u001b[1;92m ≈≈≈ Aus der Ferne hörst du ein dumpfes Rauschen ≈≈≈\u001b[0m", 112));
        s.append(TextTools.emptyLines(1));
        String text = "Du kommst auf einen rauschenden Wasserfall zu. Dort holst du dir eine kleine Erfrischung, trinkst einen kleinen Schluck Wasser und holst dir dadurch etwas mehr Lebensenergie.";
        s.append(TextTools.addPadding(text, 112, 12));
        s.append(TextTools.emptyLines(1));

        s.appendLine(TextTools.wrapToLength("Deinen Durst hast du nun gelöscht und  wieder \u001b[1;92m 5 Einheiten mehr an Lebensenergie.\u001b[0m", 112));
        s.append(TextTools.emptyLines(2));
        s.appendLine("Gib <weiter> ein, um fortzufahren.");

        character.addHealth(5);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
