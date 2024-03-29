package de.on19.mooscraft.game.worlds;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;

public abstract class Spot {

    private World world;

    public Spot(World world) {
        this.world = world;
    }

    public World getWorld() {
        return this.world;
    }

    public abstract void onEnter(Game game, Character character);

}
