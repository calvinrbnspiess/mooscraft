package de.on19.mooscraft.game.worlds.world4;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.game.screens.Screen;
import de.on19.mooscraft.utils.TextTools;

public class Spot1 extends Spot {

    public Spot1(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(TextTools.centerInRow("≈≈≈ Eine Waffe? ≈≈≈", 112));
        s.append(TextTools.emptyLines(1));
        String text = "Du triffst auf einen Waffenhändler er händigt dir zu deiner Verteidigung eine Waffe aus.";
        s.append(TextTools.addPadding(text, 112, 12));
        s.append(TextTools.emptyLines(1));

        s.appendLine(TextTools.wrapToLength("Du bekommst 10 Einheiten an Stärke.", 112));
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
