package de.on19.mooscraft.game.worlds.world3;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.TextTools;

public class Spot1 extends Spot {

    public Spot1(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(TextTools.centerInRow("≈≈≈ Unertwartete Begegnung ≈≈≈", 112));
        s.append(TextTools.emptyLines(1));
        String text = "Der Riese Preisler ist eigentlich gutmütig jedoch hast du dich vor seiner Größe erschrocken.";
        s.append(TextTools.addPadding(text, 112, 12));
        s.appendLine("Und verlierst deswegen nun 10 Einheiten deiner Lebensenergie. Gib <weiter> ein, um fortzufahren.");

        character.addHealth(-10);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
