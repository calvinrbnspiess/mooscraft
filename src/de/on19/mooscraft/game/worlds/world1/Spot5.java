package de.on19.mooscraft.game.worlds.world1;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

public class Spot5 extends Spot {

    public Spot5(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(StringTools.centerInRow("≈≈≈ Im Nebel ≈≈≈", 112));
        s.append(StringTools.emptyLines(1));
        s.appendLine(game.getProgressIndicator(character));
        s.append(StringTools.emptyLines(2));
        String text = "Langsam verlierst du mehr und mehr die Sicht. Du steckst in einem dichten undurchdringlichen Nebel und versuchst vorsichtig weiterzugehen um herauszukommen. Nach kurzer Zeit lichtet sich auch schon der Nebel und du siehst etwas auf dich zukommen.";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Du gehst immer weiter darauf zu. Gib <weiter> ein, um fortzufahren.");

        game.getRenderer().printScreen(s, true);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {
            System.out.println("exception");

            e.printStackTrace();
        }
        System.out.println("after");
    }

}
