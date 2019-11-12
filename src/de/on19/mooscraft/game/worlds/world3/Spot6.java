package de.on19.mooscraft.game.worlds.world3;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.screens.Screen;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.utils.TextTools;

public class Spot6 extends Spot {

    public Spot6(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(TextTools.centerInRow("≈≈≈ Angriff aus dem Nichts ≈≈≈", Game.TERMINAL_WIDTH));
        s.append(TextTools.emptyLines(1));
        String text = "Ein fieser unvorhersehbarer Angriff eines Schützen aus der Ferne sorgt dafür, dass du nun den Weg mit einem Pfeil in deinem Körper weiter gehen musst.";
        s.append(TextTools.addPadding(text, Game.TERMINAL_WIDTH, Game.TERMINAL_PADDING));
        s.append(TextTools.emptyLines(1));

        s.appendLine(TextTools.wrapToLength("Durch diesen Angriff verlierst du \u001b[1;91m20 Einheiten Lebensenergie.\u001b[0m", Game.TERMINAL_WIDTH));
        s.append(TextTools.emptyLines(2));
        s.appendLine("Gib <weiter> ein, um fortzufahren.");

        character.addHealth(-20);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
