package de.on19.mooscraft.game.worlds.world1;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.screens.Screen;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.utils.TextTools;

public class Spot1 extends Spot {

    public Spot1(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();

        s.appendLine(TextTools.centerInRow("≈≈≈ Tief im Odenwald ≈≈≈", 112));
        s.append(TextTools.emptyLines(2));
        String text = "Mester lebt tief im Odenwald, alleine und mit einem kleinen Drachen “Exernius”. Begegnest du seiner vermoosten Hütte, gib acht! Denn die Nähe eines Eindringlings zu seinem Heim weckt Exernius und löst einen Stromkreis aus, aus welchem du nicht entfliehen kannst bis Exernius dich besiegt hat.";
        s.append(TextTools.addPadding(text, 112, 12));
        s.append(TextTools.emptyLines(1));
        s.appendLine(TextTools.wrapToLength("Du nimmst den Kampf auf und verlierst \u001b[1;95m5 Einheiten an Lebensenergie.\u001b[0m", 112));
        s.append(TextTools.emptyLines(2));
        s.appendLine("Gib <weiter> ein, um fortzufahren.");

        character.addHealth(-5);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}