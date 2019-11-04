package de.on19.mooscraft.game.worlds;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.ActionHandler;
import de.on19.mooscraft.game.interaction.actions.GameAction;
import de.on19.mooscraft.game.screens.ChooseScreen;
import de.on19.mooscraft.renderer.Renderer;
import de.on19.mooscraft.utils.StringTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public abstract class World {

    private List<Spot> spotsPool;
    private List<Spot[]> paths;
    private ChooseScreen screen;
    private Random randomizer;

    private final static int PATH_LENGTH = 3;
    private Spot[] chosenPath;

    /**
     * Every subclass should push all allowed spots to spotsPool and initializes paths
     */
    public World(String[] description, String instruction) {
        this.spotsPool = new ArrayList<Spot>();
        this.randomizer = new Random();
        this.paths = new ArrayList<Spot[]>();
        this.screen = new ChooseScreen();

        this.screen.setContent(description);
        this.screen.setInstruction(instruction);
    }

    public List<Spot> getSpotsPool() {
        return spotsPool;
    }

    public void setSpotsPool(List<Spot> spotsPool) {
        this.spotsPool = spotsPool;
    }

    public void generatePath(String description) throws UnsupportedOperationException {
        this.generatePath(description, PATH_LENGTH);
    }

    private void generatePath(String description, int pathLength) throws UnsupportedOperationException {
        if(pathLength > this.spotsPool.size()) {
            throw new UnsupportedOperationException("not enough unused spots left");
        }

        Spot[] path = new Spot[pathLength];

        for(int i = 0; i < pathLength; i++) {
            // remove random element from spotsPool
            path[i] = this.spotsPool.remove(this.randomizer.nextInt(this.spotsPool.size()));
        }

        this.paths.add(path);
        this.screen.addOption(description);
    }

    public static int getPathLength() {
        return PATH_LENGTH;
    }

    public void setChosenPath(Spot[] chosenPath) {
        this.chosenPath = chosenPath;
    }
    
    public void onEnter(Game game, Character character) throws InterruptedException {
        game.getRenderer().printScreen(this.screen);

        game.getHandler().waitForAction(new GameAction() {
            @Override
            public void onCommand(String[] args, ActionHandler handler) {
                // TODO user enters "." or only a part of option that is contained in every option
                // TODO should merge args to single string?


                // we need to leave this onCommand-Method in order to be able to wait for new actions, so we set an class variable with chosenPath
                for(Spot[] path : paths) {
                    if (!StringTools.contains(screen.getFormattedOptions()[paths.indexOf(path)], args[0])) {
                        continue;
                    }
                    setChosenPath(path);
                }
            }
        });

        // TODO this.chosenPath should never be null

        for(Spot spot : this.chosenPath) {
            character.increaseVisitedSpots();
            spot.onEnter(game, character);
        }
    }

}