package de.on19.mooscraft.game.worlds.world3;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.utils.TextTools;

public class World3 extends World {

    public World3() throws UnsupportedOperationException {
        super(new String[]{TextTools.wrapToLength("Du befindest dich nun am Eingang der dritten Welt von Turismaga. Um durch den Hexenturm hindurch zur finalen Welt zu gelangen musst du dich nun gegenüber verzauberter Wesen beweisen. Sie werden alles daran setzten dir deine magischen Kräfte, sowie deine letzte Lebensenergie zu rauben. Gib Acht auf dich!.", Game.TERMINAL_WIDTH),
                        "                                             .:;. .::.    .:;. ,:.                                              ",
                        "                                             .oo:,:oo:,,,,:oo:;lo'                                              ",
                        "                                             .ldddddddddddddodddo.                                              ",
                        "                                              .coooddoodddddoodc.                                               ",
                        "                                               ,odddddddddddddd;                                                ",
                        "                                               ,dddddoooodddddd,                                                ",
                        "                                               .:ddddollodddddc.                                                ",
                        "                                                ;ddddddddddddd:                                                 ",
                        "                                               .cdddddddddddodc.                                                ",
                        "                                               ,ddddddddddddood,                                                ",
                        "                                               ;ddodddddddddddd:                                                ",
                        "                                              .ldooddddooddddddo'                                               ",
                        "                                              .loodddoooooodddoo,                                               ",
                        "                                              ,ooodddooooooooooo;                                               ",
                        "                                             .,;;;;;;;;;;;;;;;;;,.                                              "},
                "Du steuerst auf einen Wegscheid zu und musst eine Entscheidung treffen.");

        super.getSpotsPool().add(new Spot1(this));
        super.getSpotsPool().add(new Spot2(this));
        super.getSpotsPool().add(new Spot3(this));

        super.getSpotsPool().add(new Spot4(this));
        super.getSpotsPool().add(new Spot5(this));
        super.getSpotsPool().add(new Spot6(this));

        // add all 6 spots
        super.generatePath("Wählst du diesen Weg, warten viele Aufgaben auf dich. Doch nimm dich in Acht vor deinen Gegnern.");
        super.generatePath(
                "Auch hier erwartet dich sowohl Gutes als auch Böses, sei auf alles gefasst.");
    }

}

