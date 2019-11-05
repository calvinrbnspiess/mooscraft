package de.on19.mooscraft.game.worlds.world3;

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
        s.append(game.getStatsIndicator(character));
        s.append(StringTools.emptyLines(2));
        String text = "Ein fieser unvorhersehbarer Angriff des Schützen aus der Ferne sorgt dafür, dass du nun den Weg mit einem Pfeil in deinem Körper weiter gehen musst.";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Durch diesen Angriff verlierst du 20 Einheiten Lebensenergie. Gib <weiter> ein, um fortzufahren.");

        game.printGameScreen(s);
        character.addHealth(-20);


        try {
            game.getHandler().waitForAction(new ContinueAction());
        } catch (InterruptedException e) {
            System.out.println("exception");

            e.printStackTrace();
        }
        System.out.println("after");
    }

}
