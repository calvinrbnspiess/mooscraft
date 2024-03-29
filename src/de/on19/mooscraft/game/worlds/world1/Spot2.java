package de.on19.mooscraft.game.worlds.world1;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.screens.Screen;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.utils.TextTools;

public class Spot2 extends Spot {

    public Spot2(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();

        s.appendLine(TextTools.centerInRow("≈≈≈ Mitten im Odenwald ≈≈≈", TextTools.TERMINAL_WIDTH));
        s.append(TextTools.emptyLines(2));
        String text = "Hey du, ich bin klein Urmel, kannst du mir bitte weiterhelfen? Ich finde einfach nicht mehr nachhause! Es ist schon so spät geworden. Dank deiner Hilfe gelangt der kleine Urmel wieder zu seinem Unterbau.";
        s.append(TextTools.addPadding(text, TextTools.TERMINAL_WIDTH, TextTools.TERMINAL_PADDING));
        s.append(TextTools.emptyLines(1));
        s.appendLine(TextTools.wrapToLength("Das motiviert dich sehr, wodurch du \u001b[1;95m10 Einheiten an Lebensenergie\u001b[0m gewinnst.", TextTools.TERMINAL_WIDTH));
        s.append(TextTools.emptyLines(2));
        s.appendLine("Gib <weiter> ein, um fortzufahren.");

        character.addHealth(10);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
