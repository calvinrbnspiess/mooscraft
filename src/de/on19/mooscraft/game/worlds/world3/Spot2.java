package de.on19.mooscraft.game.worlds.world3;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

public class Spot2 extends Spot {

    public Spot2(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(StringTools.centerInRow("≈≈≈ Ein Zelt ≈≈≈", 112));
        s.append(StringTools.emptyLines(1));
        String text = "Auf deinem Weg zum Hexenturm kommst du am Zelt der Heilerin vorbei. Die Wunden deines letztens Kampfes werden verbunden und deine Chakra-Energie geerdet du lädst der Glaube an dich selbst wird wieder größer.";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Du hast nun wieder 10 Einheiten mehr Willenskraft. Gib <weiter> ein, um fortzufahren.");

        character.addWillpower(10);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {
            System.out.println("exception");

            e.printStackTrace();
        }
        System.out.println("after");
    }

}
