package de.on19.mooscraft.game.worlds.world1;

import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;

import java.util.List;

public class World1 extends World {

    public World1() throws UnsupportedOperationException {
        super(new String[]{ "Welt1" } , "Wähle einen Weg.");

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