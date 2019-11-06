package de.on19.mooscraft.game.worlds.world2;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Renderer;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

public class Spot3 extends Spot {

   /* import de.on19.mooscraft.renderer.Renderer;
    import de.on19.mooscraft.renderer.Screen;
    */
    public Spot3(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(StringTools.centerInRow("≈≈≈ Unerwartetes Hinterniss ≈≈≈", 112));
        s.append(StringTools.emptyLines(1));
        s.appendLine(game.getProgressIndicator(character));
        s.append(StringTools.emptyLines(2));
        String text = "Plötzlich verfängst du dich in einem riesigen verworrendem Etwas und kannst dich kaum mehr bewegen. Du erkennst eine gigantische Spinne auf dich zulaufen. Jetzt weißt du es, du bist in einem sehr festem Spinnennetz gefangen und die Spinne hat Hunger. Hast du genügend Stärke (>25), dann schaffst du es dich gerade rechtzeitig loszureißen, wenn aber nicht knabbert dich die Spinne an.";
        /*s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Du kannst dich befreien aber verlierst 5 Einheiten an Lebensenergie und Stärke. Gib <weiter> ein, um fortzufahren.");*/

        game.getRenderer().printScreen(s, true);

       /* Screen spider = new Screen();
        String wonspider = "Du hattest genügend Stärke und konntest dich aus dem Spinnennetz ohne weiteres befreien.";
        String lostspider = "Oh nein, leider hattest du nicht genügend Stärke und verlierst nun 5 Einheiten Lebensenergie.";

        if (character.getStrength() >= 25) {
            spider.append(StringTools.addPadding(wonspider, 112, 12));
        } else {
            spider.append(StringTools.addPadding(lostspider, 112, 12));
            && character.addHealth(-5);
        }
        renderer.printScreen(Spot3);
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
