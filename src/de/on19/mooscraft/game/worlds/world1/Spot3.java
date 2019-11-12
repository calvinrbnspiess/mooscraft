package de.on19.mooscraft.game.worlds.world1;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.screens.Screen;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.utils.TextTools;

public class Spot3 extends Spot {

    public Spot3(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();

        s.appendLine(TextTools.centerInRow("≈≈≈ In einem Zelt im Odenwald ≈≈≈", Game.TERMINAL_WIDTH));
        s.append(TextTools.emptyLines(2));
        String text1 = "Die Seherin sagt dir deine Zukunft voraus. Dafür musst du ihr leider etwas deiner Stärke abgeben. Deine Prophezeiung lautet:";
        s.append(TextTools.addPadding(text1, Game.TERMINAL_WIDTH, Game.TERMINAL_PADDING));
        s.append(TextTools.emptyLines(1));
        String text2 = "Ich sehe Dunkles kommen.";
        s.append(TextTools.addPadding(text2, Game.TERMINAL_WIDTH, Game.TERMINAL_PADDING));
        s.append(TextTools.emptyLines(1));
        String text3 = "Um deinem Untergang zu entkommen musst du der Seherin etwas von deiner Stärke schenken.";
        s.append(TextTools.addPadding(text3, Game.TERMINAL_WIDTH, Game.TERMINAL_PADDING));
        s.append(TextTools.emptyLines(1));
        s.appendLine(TextTools.wrapToLength("Du verlierst \u001b[1;95m5 Einheiten an Stärke\u001b[0m und gehst verwirrt weiter.", Game.TERMINAL_WIDTH));
        s.append(TextTools.emptyLines(2));
        s.appendLine("Gib <weiter> ein, um fortzufahren.");

        character.addStrength(-5);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
