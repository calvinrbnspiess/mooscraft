package de.on19.mooscraft.game.worlds.world1;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

public class Spot4 extends Spot {

    public Spot4(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();

        s.appendLine(StringTools.centerInRow("\u001b[1;95m≈≈≈ Plötzlich auf dem Weg ≈≈≈", 112));
        s.append(StringTools.emptyLines(2));
        String text = "Auf einmal hörst du ein Zischen, ganz aus der Nähe. Eine schwarz glänzende Schlange bewegt sich auf dich zu. Du bist nicht schnell genug der giftige Biss trifft dich.";
        s.append(StringTools.addPadding(text, 112, 12));
        s.append(StringTools.emptyLines(1));
        s.appendLine("Du verlierst 5 Einheiten an Lebensenergie, erschöpft gehst du weiter. Gib <weiter> ein, um fortzufahren.");

        game.printGameScreen(s);
        character.addHealth(-5);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {
            System.out.println("exception");

            e.printStackTrace();
        }
        System.out.println("after");
    }

}
