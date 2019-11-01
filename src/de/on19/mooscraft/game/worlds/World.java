package de.on19.mooscraft.game.worlds;

import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.renderer.Renderer;

import java.util.ArrayList;
import java.util.List;


public abstract class World {


    private List<Spot> spots;
    private String[] description;
    private String[] possiblePaths;
    private final int PATH_LENGTH = 3;

    public List<Spot> getSpots() {
        return this.spots;
    }


    // shuffle -> possiblePaths.push ( spots.take 1, spots.take 1, spots.take 1 ) -> push other half

    public List<Spot> getFirstPath() {
        int spotsAmount = this.getSpots().size();

        return this.getSpots().subList(0, PATH_LENGTH - 1);
    }

    public List<Spot> getSecondPath() {
        return this.getSpots().subList(PATH_LENGTH, spots.size() - 1);
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