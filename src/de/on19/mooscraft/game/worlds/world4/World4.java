package de.on19.mooscraft.game.worlds.world4;

import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.utils.StringTools;

public class World4 extends World {

    public World4() throws UnsupportedOperationException {
        super(new String[]{       StringTools.wrapToLength("Nicht mehr lange und du hast es geschafft die begehrte Burg zu erreichen. In der finalen vierten Welt Arcis Borbetomagus wird nun noch einmal deine Kraft im Kampf gefordert. Ob Duell oder Truppen Angriff, du wirst auf allen Ebenen ein letztes Mal gefordert. Wenn du durch Sumpf und Moor gegangen und all dies überlebst hast du das Zeug dazu der neuer Anwärter für die Herrschaft über Mooscraft zu werden.\n", 112),
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
                "Du hast die letzte Gabelung erreicht. Entscheide dich bitte welcher Weg dich zu deinem Ziel bringt..");

        super.getSpotsPool().add(new Spot1(this));
        super.getSpotsPool().add(new Spot2(this));
        super.getSpotsPool().add(new Spot3(this));

        super.getSpotsPool().add(new Spot4(this));
        super.getSpotsPool().add(new Spot5(this));
        super.getSpotsPool().add(new Spot6(this));

        // add all 6 spots
        super.generatePath("Gehst du links, lauern dunkle Gestalten in den Tiefen des Moors. ");
        super.generatePath(
                "Auf der anderen Seite sieht es ganz danach aus, als wenn dich das Moor tief in den Sumpf hinunterziehen will.");
    }

}

