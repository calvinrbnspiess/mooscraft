package de.on19.mooscraft.game.worlds.world2;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.screens.Screen;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.utils.TextTools;

public class Spot5 extends Spot {

    public Spot5(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(TextTools.centerInRow("≈≈≈ Ein ungewöhnlicher Fund ≈≈≈", TextTools.TERMINAL_WIDTH));
        s.append(TextTools.emptyLines(1));
        String text = "Im Gebüsch fällt dir eine merkwürdig leuchtende Flasche auf. Du hebst sie auf und aus der Flasche weicht Nebel aus bis dieser sich zu einem großen Geist formt. “Ich habe dich erwartet.”, sagt Romanus der Flaschengeist. “Wünsche erfülle ich zwar keine, dafür trage ich dich ein Stück den Berg hinauf, so dass du deine Kräfte einsparen kannst.” ";
        s.append(TextTools.addPadding(text, TextTools.TERMINAL_WIDTH, TextTools.TERMINAL_PADDING));
        s.append(TextTools.emptyLines(1));

        s.appendLine(TextTools.wrapToLength("Genau das macht er dann auch und kurz darauf siehst du schon ein neues Abenteuer, das auf dich wartet.", TextTools.TERMINAL_WIDTH));
        s.append(TextTools.emptyLines(2));
        s.appendLine("Gib <weiter> ein, um fortzufahren.");

        character.addWitchcraft(-10);
        game.printGameScreen(s);

        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {


            e.printStackTrace();
        }

    }

}
