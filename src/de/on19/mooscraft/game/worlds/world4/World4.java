package de.on19.mooscraft.game.worlds.world4;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.utils.TextTools;

import java.util.ArrayList;
import java.util.List;

public class World4 extends World {

    // same like before - just fixed formatting
    // cannot define variables before callling super() -> so had to create new method

    public World4() throws UnsupportedOperationException {
        super(getText(),
                "Du hast die letzte Gabelung erreicht. Welcher Weg wird dich zur Herrschaft führen?.");

        super.getSpotsPool().add(new Spot1(this));
        super.getSpotsPool().add(new Spot2(this));
        super.getSpotsPool().add(new Spot3(this));

        super.getSpotsPool().add(new Spot4(this));
        super.getSpotsPool().add(new Spot5(this));
        super.getSpotsPool().add(new Spot6(this));

        // add all 6 spots
        super.generatePath("Gehst du links, lauern dunkle Gestalten in den Tiefen des Moors. ");
        super.generatePath(
                "Auf der anderen Seite sieht es aus, als wenn dich das Moor tief in den Sumpf hinunterziehen will.");
    }

    private static String[] getText() {
        List<String> text = new ArrayList<String>();

        text.add(TextTools.wrapToLength("Nicht mehr lange und du hast es geschafft die begehrte Burg zu erreichen. In der finalen vierten Welt Arcis Borbetomagus wird nun noch einmal deine Kraft im Kampf gefordert. Ob Duell oder Truppenangriff, du wirst auf allen Ebenen ein letztes Mal gefordert. Wenn du durch Sumpf und Moor gegangen und all dies überlebst hast du das Zeug dazu der/die neue/r Anwärter/in für die Herrschaft über Mooscraft zu werden.", Game.TERMINAL_WIDTH));

        TextTools.append(text, TextTools.centerInRow(new String[]{
                "                    ,ll                    ",
                "                    :Oko                   ",
                "          'oc.    ddOKkdo,   .ol.          ",
                "         'kWXc.  ,lkNMXdc.  .xWNo.         ",
                "         lNMMO' 'cckNMXdc:. :XMMK,         ",
                "   .::.  'OWXo oXMMMMMMMMW0  kWNd.  .c;    ",
                "  .oNXc.  cNk, MMMMMMMMMMMMN :XK,  .xWK:   ",
                "  ,0MMO'  cNk,dMMMMMMMMMMMMWc;X0,  :XMWx.  ",
                "  .xMWo.':xW0oOMMMMMMMMMMMMWxdNXo:..kMNc   ",
                "  .xMWo.,dXMMMMMMMMMMMMMMMMMMMMM0o..kMNc   ",
                ".;:0MMk:,,kMMMMMMMMMMMMMMMMMMMMWo';cKMWx;;.",
                ",OWMMMMWx;kMMMMMMMMMMMMMMMMMMMMWo:0WMMMMNd.",
                " lWMMMMN:.kMMMMMMMMMMMMMMMMMMMMMo.dMMMMMK; ",
                " oWMMMMNc'OMMMMMMMMMMMMMMMMMMMMMo.xMMMMMX; ",
                " lWMMMMMK0NMMMMMMMMMMMMMMMMMMMMMX0NMMMMMK; ",
                " lWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMK; ",
                " oWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMK; ",
                " ;dxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxo. "
        }, Game.TERMINAL_WIDTH));

        return text.toArray(new String[0]);
    }

}

