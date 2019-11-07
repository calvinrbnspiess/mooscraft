package de.on19.mooscraft.game.characters;

import de.on19.mooscraft.game.screens.GameOverScreen;

public class Character {

    private String name;

    //overall declaration of variables and Methods --> initialization in single character classes
    private int health;
    private int strength;
    private int witchcraft;
    private int willpower;
    private int wisdom;

    private int visitedSpots;
    private GameOverScreen gameOverScreen;


    public Character() {
        this(0, 0, 0, 0, 0);
        /**
         * constructor gives actual values to the parameters given to the variables before via Character constructor
         *this.  refers to class attributes
         */
    }

    public Character(String name) {
        this(0, 0, 0, 0, 0);
        this.setName(name);
    }

    public Character(int health, int strength, int witchcraft, int willpower, int wisdom) {
        this.name = "Unbekannter Spieler";
        /**constructor
         * gives basic values (in brackets) to the variables (called by this.)
         */
        this.health = health;
        /**this: refers to class declared before above (e.g. public int health)
         * only "health" without "this" just refers to parameters in brackets within this Method
         */
        this.strength = strength;
        this.witchcraft = witchcraft;
        this.willpower = willpower;
        this.wisdom = wisdom;
        this.visitedSpots = 0;
    }

    public static String[] getIcon() {
        // return no standard icon
        return new String[0];
    }

    public int getHealth() { //no parameters necessary since there is only a return value and no value provided into a variable
        return health;
    }

    /**
     * getter and setter methods are necessary to call them later in other classes and change values
     * therefore, they are public
     */

    //health
    public void setHealth(int health) {
        this.health = health;

        if (this.health <= 0 && this.gameOverScreen != null) {
            this.gameOverScreen.print();
        }
    }

    public void addHealth(int health) {
        this.setHealth(this.getHealth() + health);
    }

    //strength
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    //witchcraft

    public void addStrength(int strength) {     //character`s strength value token + strength value to be added = new strength value
        int strengthAfter = this.getStrength() + strength;
        if (strengthAfter < 0) {          // sobald der Wert unter 0 geht
            this.setStrength(0);          // wird er gleich 0 gesetzt (bei jedem Wert außer Health)
            return;
        }

        this.setStrength(strengthAfter);
    }

    public int getWitchcraft() {
        return witchcraft;
    }

    public void setWitchcraft(int witchcraft) {
        this.witchcraft = witchcraft;
    }

    public void addWitchcraft(int witchcraft) {

        int witchcraftAfter = this.getWitchcraft() + witchcraft;
        if (witchcraftAfter < 0) {
            this.setWitchcraft(0);
            return;
        }
        this.setWitchcraft(witchcraftAfter);
    }

    //willpower
    public int getWillpower() {
        return willpower;
    }

    public void setWillpower(int willpower) {
        this.willpower = willpower;
    }

    public void addWillpower(int willpower) {

        int willpowerAfter = this.getWillpower() + willpower;
        if (willpowerAfter < 0) {
            this.setWillpower(0);
            return;
        }
        this.setWillpower(willpowerAfter);
    }

    //wisdom
    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void addWisdom(int wisdom) {

        int wisdomAfter = this.getWisdom() + wisdom;
        if (wisdomAfter < 0) {
            this.setWisdom(0);
            return;
        }
        this.setWisdom(wisdomAfter);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void increaseVisitedSpots() {
        this.visitedSpots += 1;
    }

    public int getVisitedSpots() {
        return visitedSpots;
    }

    public GameOverScreen getGameOverScreen() {
        return this.gameOverScreen;
    }

    public void prepareGameOverScreen(GameOverScreen gameOverScreen) {
        this.gameOverScreen = gameOverScreen;
    }
}
