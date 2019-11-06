package de.on19.mooscraft.game.worlds;

import de.on19.mooscraft.game.Game;
import de.on19.mooscraft.game.characters.Character;
import de.on19.mooscraft.game.interaction.actions.ChooseAction;
import de.on19.mooscraft.game.screens.ChooseScreen;
import de.on19.mooscraft.renderer.Screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public abstract class World {

    private final static int PATH_LENGTH = 3;
    private List<Spot> spotsPool;
    private List<Spot[]> paths;
    private ChooseScreen screen;
    private Random randomizer;

    /**
     * Every subclass should push all allowed spots to spotsPool and initializes paths
     */
    public World(String[] description, String instruction) {
        this.spotsPool = new ArrayList<Spot>();
        this.randomizer = new Random();
        this.paths = new ArrayList<Spot[]>();
        this.screen = new ChooseScreen();

        this.screen.append(description);
        this.screen.setInstruction(instruction);
    }

    public static int getPathLength() {
        return PATH_LENGTH;
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
        if (pathLength > this.spotsPool.size()) {
            throw new UnsupportedOperationException("not enough unused spots left");
        }

        Spot[] path = new Spot[pathLength];

        for (int i = 0; i < pathLength; i++) {
            // remove random element from spotsPool
            path[i] = this.spotsPool.remove(this.randomizer.nextInt(this.spotsPool.size()));
        }

        this.paths.add(path);
        this.screen.addOption(description);
    }

    public void onEnter(Game game, Character character) throws InterruptedException {
        game.printGameScreen(this.screen);

        ChooseAction chooseAction = new ChooseAction(this.screen);

        // character needs to be uniquely chosen
        while (chooseAction.getChosenOption() == null) {
            game.getHandler().waitForAction(chooseAction);

            if (chooseAction.getChosenOption() == null) {
                Screen s = new Screen();
                s.appendLine("Du hast keine eindeutige Option gewählt. Probier's nochmal.");
                game.getRenderer().printScreen(s, false);
            }
        }

        // find chosenPath by comparing index of formatted option with chosenOption

        Spot[] chosenPath = paths.get(Arrays.asList(screen.getFormattedOptions()).indexOf(chooseAction.getChosenOption()));

        for (Spot spot : chosenPath) {
            character.increaseVisitedSpots();
            spot.onEnter(game, character);
        }
    }

}