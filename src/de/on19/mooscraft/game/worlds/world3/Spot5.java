package de.on19.mooscraft.game.worlds.world3;

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
        s.appendLine(StringTools.centerInRow("≈≈≈ Tief im Odenwald ≈≈≈", 112));
        s.append(StringTools.emptyLines(1));
        s.appendLine(game.getProgressIndicator(character));
        s.append(StringTools.emptyLines(2));
        String text = "Die ominöse Frau D. lebt schon seit geraumer Zeit im Hexenturm, sie ist die gute Seele von Mooscraft.";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Deswegen schenkt sie dir deswegen 5 Einheiten Lebensenergie Gib <weiter> ein, um fortzufahren.");

        game.getRenderer().printScreen(s, true);
        character.addHealth(5);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {
            System.out.println("exception");

            e.printStackTrace();
        }
        System.out.println("after");
    }

}
