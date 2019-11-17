package de.on19.mooscraft.game.worlds.world2;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.screens.Screen;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.utils.TextTools;

public class Spot3 extends Spot {

    /* import de.on19.mooscraft.renderer.Renderer;
     import de.on19.mooscraft.game.screens.Screen;
     */
    public Spot3(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(TextTools.centerInRow("≈≈≈ Unerwartetes Hinterniss ≈≈≈", TextTools.TERMINAL_WIDTH));
        s.append(TextTools.emptyLines(1));
        String text = "Plötzlich verfängst du dich in einem riesigen, verworrenem Etwas und kannst dich kaum mehr bewegen. Du erkennst eine gigantische Spinne auf dich zulaufen. Jetzt weißt du es, du bist in einem sehr festem Spinnennetz gefangen und die Spinne hat Hunger. Hast du genügend \u001b[1;92m Stärke (>25)\u001b[0m, dann schaffst du es dich gerade rechtzeitig loszureißen, wenn aber nicht knabbert dich die Spinne an.";
        s.append(TextTools.addPadding(text, TextTools.TERMINAL_WIDTH, TextTools.TERMINAL_PADDING));
        s.append(TextTools.emptyLines(1));

        String wonspider = "Du hattest genügend Stärke und konntest dich aus dem Spinnennetz ohne Weiteres befreien.";
        String lostspider = "Oh nein, leider hattest du nicht genügend Stärke und verlierst nun \u001b[1;92m 5 Einheiten Lebensenergie.\u001b[0m";

        // ausgabe in abhängigkeit von dem besagten Parameter

        if (character.getStrength() >= 25) {
            s.append(TextTools.addPadding(wonspider, TextTools.TERMINAL_WIDTH, TextTools.TERMINAL_PADDING));
        } else {
            s.append(TextTools.addPadding(lostspider, TextTools.TERMINAL_WIDTH, TextTools.TERMINAL_PADDING));
            character.addHealth(-5);
        }
        s.append(TextTools.emptyLines(2));
        // if bedingung wenn stärke >=25 dann wird nichts abgezogen ansonsten wird Lebensenergie abgezogen

        s.appendLine("Gib <weiter> ein, um fortzufahren.");


        game.printGameScreen(s);
        // screen wird danach ausgegeben

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
