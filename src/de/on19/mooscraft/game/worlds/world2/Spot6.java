package de.on19.mooscraft.game.worlds.world2;

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
        s.appendLine(TextTools.centerInRow("≈≈≈ Der Wald lichtet sich ≈≈≈", Game.TERMINAL_WIDTH));
        s.append(TextTools.emptyLines(1));

        String text = "Du steuerst auf eine Klippe zu und siehst es geht 100 Meter weit in die Tiefe. Hast du genügend Zauberkraft (>20), springst du über die Klippe. Wenn aber nicht, fällst du mitten im Sprung, landest auf dem Boden und verlierst somit weitere wertvolle Lebensenergie.";
        s.append(TextTools.addPadding(text, Game.TERMINAL_WIDTH, 12));
        s.append(TextTools.emptyLines(1));

        String woncliff = "Du hattest genügend Zauberkraft und konntest die Klippe problemlos überwinden.";
        String lostcliff = "Oh nein, leider hattest du nicht genügend Zauberkraft und verlierst nun 5 Einheiten Lebensenergie.";

        if (character.getWitchcraft() >= 20) {
            s.append(TextTools.addPadding(woncliff, Game.TERMINAL_WIDTH, 12));
        } else {
            s.append(TextTools.addPadding(lostcliff, Game.TERMINAL_WIDTH, 12));
            character.addHealth(-5);
        }

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
