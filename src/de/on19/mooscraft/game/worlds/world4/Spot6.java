package de.on19.mooscraft.game.worlds.world4;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.TextTools;

public class Spot6 extends Spot {

    public Spot6(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(TextTools.centerInRow("≈≈≈ Die Untiefen des Mooscraft-Moores ≈≈≈", 112));
        s.append(TextTools.emptyLines(1));
        String text = "Die Nymphe lauert in den tiefen des Moores, du bemerkst sie leider zu spät, sie versucht  sogar dich in den Moor dein bevorstehendes Ende zu locken allerdings vergebens.";
        s.append(TextTools.addPadding(text, 112, 12));
        s.appendLine("Sie raubt dir mit ihrer schrillen Stimme 10 Einheiten deiner Lebensenergie. Gib <weiter> ein, um fortzufahren.");

        character.addHealth(-10);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
