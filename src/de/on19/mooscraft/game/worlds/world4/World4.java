package de.on19.mooscraft.game.worlds.world4;

import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.game.worlds.world1.Spot1;
import de.on19.mooscraft.utils.StringTools;

public class World4 extends World {

    public World4() throws UnsupportedOperationException {
        super(new String[]{       StringTools.wrapToLength("Nicht mehr lange und du hast es geschafft die begehrte Burg zu erreichen. In der finalen vierten Welt wird nun noch einmal deine Kraft im Kampf gefordert. Ob Duell oder Truppen Angriff, du wirst auf allen Ebenen ein letztes Mal gefordert. Wenn du durch Sumpf und Moor gegangen und all dies überlebst hast du das Zeug dazu der neuer Anwärter für die Herrschaft über Mooscraft zu werden.\n", 112),
                        "                                                       ,ll                                                        ",
                        "                                                       :Oko                                                       ",
                        "                                             'oc.    ddOKkdo,   .ol.                                              ",
                        "                                            'kWXc.  ,lkNMXdc.  .xWNo.                                             ",
                        "                                            lNMMO' 'cckNMXdc:. :XMMK,                                             ",
                        "                                      .::.  'OWXo oXMMMMMMMMW0  kWNd.  .c;                                        ",
                        "                                     .oNXc.  cNk, MMMMMMMMMMMMN :XK,  .xWK:                                       ",
                        "                                     ,0MMO'  cNk,dMMMMMMMMMMMMWc;X0,  :XMWx.                                      ",
                        "                                     .xMWo.':xW0oOMMMMMMMMMMMMWxdNXo:..kMNc                                       ",
                        "                                     .xMWo.,dXMMMMMMMMMMMMMMMMMMMMM0o..kMNc                                       ",
                        "                                   .;:0MMk:,,kMMMMMMMMMMMMMMMMMMMMWo';cKMWx;;.                                    ",
                        "                                   ,OWMMMMWx;kMMMMMMMMMMMMMMMMMMMMWo:0WMMMMNd.                                    ",
                        "                                    lWMMMMN:.kMMMMMMMMMMMMMMMMMMMMMo.dMMMMMK;                                     ",
                        "                                    oWMMMMNc'OMMMMMMMMMMMMMMMMMMMMMo.xMMMMMX;                                     ",
                        "                                    lWMMMMMK0NMMMMMMMMMMMMMMMMMMMMMX0NMMMMMK;                                     ",
                        "                                    lWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMK;                                     ",
                        "                                    oWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMK;                                     ",
                        "                                    ;dxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxo.                                   "},
                "Wähle einen Weg.");

        super.getSpotsPool().add(new Spot1(this));
        super.getSpotsPool().add(new Spot1(this));
        super.getSpotsPool().add(new Spot1(this));

        super.getSpotsPool().add(new Spot1(this));
        super.getSpotsPool().add(new Spot1(this));
        super.getSpotsPool().add(new Spot1(this));

        // add all 6 spots
        super.generatePath("Den linken Wege musste gehen");
        super.generatePath(
                "Nur wer sein Ziel kennt, findet diesen Weg.");
    }

}
