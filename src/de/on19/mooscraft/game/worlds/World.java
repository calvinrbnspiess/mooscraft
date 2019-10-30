package de.on19.mooscraft.game.worlds;

import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.renderer.Renderer;

import java.util.ArrayList;
import java.util.List;


public abstract class World {


    private List<Spot> spots;
    private String[] description;
    private String[] possiblePaths;

    public List<Spot> getSpots() {
        return this.spots;
    }


    public World() {
        this.spots = new ArrayList<Spot>();
    }


    public void onEnter(Renderer renderer, ActionHandler handler) {
        /**provides renderer and action handler as
         * parameters, so actions can be received and output produced
         */

    }





}