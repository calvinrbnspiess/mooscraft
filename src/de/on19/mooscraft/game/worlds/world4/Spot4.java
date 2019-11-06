package de.on19.mooscraft.game.worlds.world4;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ContinueAction;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.renderer.Screen;
import de.on19.mooscraft.utils.StringTools;

public class Spot4 extends Spot {

    public Spot4(World world) {
        super(world);
    }

    @Override
    public void onEnter(Game game, Character character) {
        Screen s = new Screen();
        s.appendLine(StringTools.centerInRow("≈≈≈ Abgekommen? ≈≈≈", 112));
        s.append(StringTools.emptyLines(1));
        String text = "Die Wege der finalen Welt sind nicht gerade gut zu erkennen, du geräts von der Route und landest Mitten in einem Werwolfsrudel. Sie sehen dich als Bedrohung und greifen dich an. Glücklicherweise findest du zurück auf den befestigten Weg und das Rudel lässt dich ziehn.";
        s.append(StringTools.addPadding(text, 112, 12));
        s.appendLine("Ganz ohne Schramme bist du nicht weg gekommen weswegen du Lebensenergie 20 verlierst. Gib <weiter> ein, um fortzufahren.");

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
