package de.on19.mooscraft.game.worlds.world2;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.utils.TextTools;

public class World2 extends World {

    public World2() throws UnsupportedOperationException {
        super(new String[]{TextTools.wrapToLength("Langsam erreichst du den bekanntesten Fluss in ganz Mooscraft. Die Mittelklinge ist nicht nur Dank ihres Namens furchteinflößend. Pass gut auf, dass du nicht von einer der Stromschnellen mitgerissen wirst. Um im Wasser zu überleben, braucht es höchste Konzentration und innere Ruhe. Bereite dich gut auf den nächsten Abschnitt deiner Reise vor und sei auf jede Gefahr gefasst.", Game.TERMINAL_WIDTH),
                        "                                                   ...',,,,,'..                                                 ",
                        "                                              .,cdk0KNNWWWWWNXKOo.                                              ",
                        "                                          .,lkKWMMMMMMMMMMMMMMNk,                                               ",
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
                "Erneut erwartet dich eine Abzweigung des Weges und du musst dich entscheiden. Welchen Weg wählst du?");

        super.getSpotsPool().add(new Spot1(this));
        super.getSpotsPool().add(new Spot2(this));
        super.getSpotsPool().add(new Spot3(this));

        super.getSpotsPool().add(new Spot4(this));
        super.getSpotsPool().add(new Spot5(this));
        super.getSpotsPool().add(new Spot6(this));

        // add all 6 spots
        super.generatePath("Auf diesem Weg sieht der Untergrund sehr steinig und zugewachsen aus.");
        super.generatePath(
                "Der rechte Weg hingegen ist schon einige Centimeter überflutet.");
    }

}

