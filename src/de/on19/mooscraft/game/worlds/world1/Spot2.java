package de.on19.mooscraft.game.worlds.world1;

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
        s.appendLine(StringTools.centerInRow("≈≈≈ Tief im Odenwald ≈≈≈", 112));
        s.append(StringTools.emptyLines(1));
        s.appendLine(game.getProgressIndicator(character));
        s.append(StringTools.emptyLines(2));
        String text = "Hey du, ich bin klein Urmel, kannst du mir bitte weiterhelfen? Ich finde einfach nicht mehr nachhause! Es ist schon so spät geworden. Dank deiner Hilfe gelangt der kleine Urmel wieder zu seinem Unterbau.";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Das motiviert dich sehr, wodurch du neue Lebensenergie (10) gewinnst. Gib <weiter> ein, um fortzufahren.");

        game.getRenderer().printScreen(s, true);
        character.addHealth(10);
        /*z.B. health zufügen
         * character.addhealth(parameter eingeben)
         */
        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {
            System.out.println("exception");

            e.printStackTrace();
        }
        System.out.println("after");
    }

}
