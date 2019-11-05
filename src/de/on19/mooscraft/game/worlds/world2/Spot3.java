package de.on19.mooscraft.game.worlds.world2;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

public class Spot3 extends Spot {

    public Spot3(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(StringTools.centerInRow("≈≈≈ Tief im Odenwald ≈≈≈", 112));
        s.append(StringTools.emptyLines(1));
        String text = "Plötzlich verfängst du dich in einem riesigen verworrendem Etwas und kannst dich kaum mehr bewegen. Du erkennst eine gigantische Spinne auf dich zulaufen. Jetzt weißt du es, du bist in einem sehr festem Spinnennetz gefangen und die Spinne hat Hunger. Hast du genügend Stärke (>25) und Willenskraft (>25), dann schaffst du es dich gerade rechtzeitig loszureißen, wenn aber nicht knabbert dich die Spinne an.";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Du kannst dich befreien aber verlierst 5 Einheiten an Lebensenergie und Stärke. Gib <weiter> ein, um fortzufahren.");

        game.printGameScreen(s);
        character.addHealth(-5);
        character.addStrength(-5);

        // if Strength >25 ?
        /*           z.B. health zufügen
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
