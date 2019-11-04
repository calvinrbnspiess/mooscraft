package de.on19.mooscraft.game.worlds.world4;

import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.game.worlds.world1.Spot1;
import de.on19.mooscraft.utils.StringTools;

public class World4 extends World {

    public World4() throws UnsupportedOperationException {
        super(new String[]{       StringTools.wrapToLength("Ein dichter Wald erwartet dich Ein bisschen mulmig ist dir zumute doch du weißt, du musst da durch um zur Burg Worms zu gelangen. Dieses Ziel treibt dich voran in die Dunkelheit. Auf dich warten überirdische Kämpfe, giftige Wesen, die im Odenwald lauern und dichter Nebel, der dir deine klare Sicht nimmt. Auch den berühmten Mester wirst du antreffen, also nimm dich in Acht, denn du weißt was über ihn erzählt wird.", 112), "                                                     .;;:,.                                                     ",
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

