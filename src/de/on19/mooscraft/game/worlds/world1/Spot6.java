package de.on19.mooscraft.game.worlds.world1;

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

        s.appendLine(TextTools.centerInRow("≈≈≈ Du bekommst Besuch auf deinem Weg ≈≈≈", TextTools.TERMINAL_WIDTH));
        s.append(TextTools.emptyLines(2));
        String text = "Ein zartes Wesen schwebt auf dich zu. Du erkennst eine kleine Fee. Da sie gehört hat wie tapfer du bist, schenkt sie dir Stärke.";
        s.append(TextTools.addPadding(text, TextTools.TERMINAL_WIDTH, TextTools.TERMINAL_PADDING));
        s.append(TextTools.emptyLines(1));
        s.appendLine(TextTools.wrapToLength("Du bekommst \u001b[1;95m10 Einheiten Stärke\u001b[0m.", TextTools.TERMINAL_WIDTH));
        s.append(TextTools.emptyLines(2));
        s.appendLine("Gib <weiter> ein, um fortzufahren.");

        character.addStrength(10);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
