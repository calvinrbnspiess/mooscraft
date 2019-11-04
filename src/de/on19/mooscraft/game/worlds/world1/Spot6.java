package de.on19.mooscraft.game.worlds.world1;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

public class Spot6 extends Spot {

    public Spot6(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(StringTools.centerInRow("≈≈≈ Tief im Odenwald ≈≈≈", 112));
        s.append(StringTools.emptyLines(1));
        s.appendLine(game.getProgressIndicator(character));
        s.append(StringTools.emptyLines(2));
        String text = "Ein zartes Wesen schwebt auf dich zu. Du erkennst kleine Fee. Sie möchte dir gerne einen Wunsch erfüllen, da sie gehört hat wie tapfer du bis hier warst. Mehr Lebensenergie, Stärke, Zauberkraft oder Willenskraft gewinnen?";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Entscheide dich. Gib <weiter> ein, um fortzufahren.");

        game.getRenderer().printScreen(s, true);

        /* HIER FEHLT NOCH DIE AUSWAHL MÖGLICHKEIT GIBT ES DIE ÜBERHAUPT?
         * oder kein Parameter wird bearbeitet
         * z.B. health zufügen
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
