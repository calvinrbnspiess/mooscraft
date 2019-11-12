package de.on19.mooscraft.game.worlds.world1;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.screens.Screen;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.utils.TextTools;

public class Spot5 extends Spot {

    public Spot5(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();

        s.appendLine(TextTools.centerInRow("≈≈≈ Im Nebel ≈≈≈", Game.TERMINAL_WIDTH));
        s.append(TextTools.emptyLines(2));
        String text = "Langsam verlierst du mehr und mehr die Sicht. Du steckst in einem dichten, undurchdringlichen Nebel und versuchst vorsichtig weiterzugehen um herauszukommen. Nach kurzer Zeit lichtet sich auch schon der Nebel und du siehst etwas auf dich zukommen.";
        s.append(TextTools.addPadding(text, Game.TERMINAL_WIDTH, 12));
        s.append(TextTools.emptyLines(1));
        s.appendLine(TextTools.wrapToLength("Du gehst immer weiter darauf zu.", Game.TERMINAL_WIDTH));
        s.append(TextTools.emptyLines(2));
        s.appendLine("Gib <weiter> ein, um fortzufahren.");

        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
