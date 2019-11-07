package de.on19.mooscraft.game.worlds.world3;

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
        s.appendLine(TextTools.centerInRow("≈≈≈ An einem See auf einem Felsen ≈≈≈", 112));
        s.append(TextTools.emptyLines(1));
        String text = "Sirenen-Angriff, Mischwesen mit einem Vogelkörper und einem Frauenkopf locken dich mit ihrer Stimme ins Verderben, du kannst mit deinen letzten Kräften entkommen.";
        s.append(TextTools.addPadding(text, 112, 12));
        s.append(TextTools.emptyLines(1));

        s.appendLine(TextTools.wrapToLength("Und verlierst 20 Einheiten an Stärke.", 112));
        s.appendLine("Gib <weiter> ein, um fortzufahren.");

        character.addStrength(-20);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
