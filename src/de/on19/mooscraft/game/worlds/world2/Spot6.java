package de.on19.mooscraft.game.worlds.world2;

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
        s.appendLine(TextTools.centerInRow("≈≈≈ Der Wald lichtet sich ≈≈≈", 112));
        s.append(TextTools.emptyLines(1));
        String text = "Du steuerst auf eine Klippe zu und siehst es geht 100 Meter weit in die Tiefe. Hast du genügend Zauberkraft (>20), springst du über die Klippe. Wenn aber nicht, fällst du mitten im Sprung, landest auf dem Boden und verlierst somit weitere wertvolle Lebensenergie und Stärke. ";
        s.append(TextTools.addPadding(text, 112, 12));
        s.appendLine("Diese waghalsige Aktion kostet dich 5 Einheiten an Lebensenergie und Stärke. Gib <weiter> ein, um fortzufahren.");

        character.addHealth(-5);
        character.addStrength(-5);
        game.printGameScreen(s);


        // TODO:
        /*
        Methode Auswahl
         */
        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
