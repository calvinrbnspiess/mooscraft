package de.on19.mooscraft.game.worlds.world2;

import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.utils.StringTools;

public class World2 extends World {

    public World2() throws UnsupportedOperationException {
        super(new String[]{       StringTools.wrapToLength("Langsam erreichst du den bekanntesten Fluss in ganz Mooscraft. Die Mittelklinge ist nicht nur Dank ihrem Namen sehr furchteinflößend. Pass gut auf, dass du nicht von einen der Stromstellen mitgerissen wirst. Um im Wasser zu überleben, braucht es höchste Konzentration und eine innere Ruhe. Bereite dich gut auf den nächsten Abschnitt deiner Reise vor und sie auf jede Gefahr gefasst.", 112),
                        "                                                 ...',,,,,'..                                                 ",
                "                                                   .,cdk0KNNWWWWWNXKOo.                                              ",
                "                                                 .,lkKWMMMMMMMMMMMMMMNk,                                               ",
                        "                                        'lONMMMWN0kdllkWMMMMW0:.                                                ",
                        "                                      ,xXMMMN0d:'.   cKMMMMNd.                                                  ",
                        "                                    ,kNMMW0o,.      lXMMMMK:                                                    ",
                        "                                  .dXMMNO:.        :XMMMW0;                                                     ",
                        "                                 :0WMWO:.         'OMMMKk;                            ...',,,''..               ",
                        "                               'xNMW0c.           cNMMWd..                     ..;coxO0KXXK0Okkxxdol:;'.        ",
                        "     ...                     'oXMWKo.             lWMMNl.                .';ldkKNWWNKkoc;'...  .....',,,'..     ",
                        "      .,:;.               .;dXMWKo.               ;KMMMOo;        ..,:ldOKNWMWN0xo:'.                           ",
                        "        .;loc,..      .':d0NWXkc.                  cXMMMWNOxdddxk0KXWMMMWNKko:'.                                ",
                        "           'cdkkkxxxxOKNNX0xc.                      ,xXWMMMMMMMMMMWNKOxl:'.                                     ",
                        "              .';clooolc;..                           .;cloxxxdolc;'.                                           "
},
                "Wähle einen Weg.");

        super.getSpotsPool().add(new Spot1(this));
        super.getSpotsPool().add(new Spot2(this));
        super.getSpotsPool().add(new Spot3(this));

        super.getSpotsPool().add(new Spot4(this));
        super.getSpotsPool().add(new Spot5(this));
        super.getSpotsPool().add(new Spot6(this));

        // add all 6 spots
        super.generatePath("Den linken Wege musste gehen");
        super.generatePath(
                "Nur wer sein Ziel kennt, findet diesen Weg.");
    }

}

