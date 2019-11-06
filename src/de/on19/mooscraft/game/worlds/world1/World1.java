package de.on19.mooscraft.game.worlds.world1;

import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.utils.StringTools;

public class World1 extends World {

    public World1() throws UnsupportedOperationException {
        super(new String[]{       StringTools.wrapToLength("\u001b[1;95mEin dichter Wald erwartet dich Ein bisschen mulmig ist dir zumute doch du weißt, du musst da durch um zur Burg Worms zu gelangen. Dieses Ziel treibt dich voran in die Dunkelheit. Auf dich warten überirdische Kämpfe, giftige Wesen, die im Odenwald lauern und dichter Nebel, der dir deine klare Sicht nimmt. Auch den berühmten Mester wirst du antreffen, also nimm dich in Acht, denn du weißt was über ihn erzählt wird.", 112), "                                                     .;;:,.                                                     ",
                        "                                                    ,0MMMXl.                                                    ",
                        "                                                   :KMMMMMWd.                                                   ",
                        "                                                  cXMMMMMMMMk.                                                  ",
                        "                                                .lNMMMMMMMMMWO'                                                 ",
                        "                                               .oNMMMMMMMMMMMWO,                                                ",
                        "                                              .xNMMMMMMMMMMMMMWK;                                               ",
                        "                                              .,:OMMMMMMMMMMMKl;.                                               ",
                        "                                                :XMMMMMMMMMMMNd.                                                ",
                        "                                              .cKMMMMMMMMMMMMMNk'                                               ",
                        "                                             .oXMMMMMMMMMMMMMMMWO,                                              ",
                        "                                            .xWMMMMMMMMMMMMMMMMMMK;                                             ",
                        "                                            ,kOOOOkONMMMMMWKOOOOOOl.                                            ",
                        "                                                   'OMMMMMNc                                                    ",
                        "                                                   .d0000KO,                                                    " },
                "Du stehst nun vor einer Weggabelung und musst dich entscheiden. Welchen Weg wählst du?");

        super.getSpotsPool().add(new Spot1(this));
        super.getSpotsPool().add(new Spot2(this));
        super.getSpotsPool().add(new Spot3(this));

        super.getSpotsPool().add(new Spot4(this));
        super.getSpotsPool().add(new Spot5(this));
        super.getSpotsPool().add(new Spot6(this));

        // add all 6 spots
        super.generatePath("Links sieht es duster aus, etwas weiter hinten siehst du schon eine Lichtquelle.");
        super.generatePath(
                "Dieser Weg wirkt freundlicher. Jedoch tönen unheimliche Geräusche bis zu dir hin.");
    }

}

