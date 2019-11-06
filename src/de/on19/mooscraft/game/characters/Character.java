package de.on19.mooscraft.game.characters;

import de.on19.mooscraft.renderer.Screen;

public class Character {

    private String name;

    //overall declaration of variables and Methods --> initialization in single character classes
    private int health;
    private int strength;
    private int witchcraft;
    private int willpower;
    private int wisdom;

    private int visitedSpots;

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
        this.name = "Unnamed Player";
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

    /**
     * getter and setter methods are necessary to call them later in other classes and change values
     * therefore, they are public
     */

    //health
    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() { //no parameters necessary since there is only a return value and no value provided into a variable
        return health;
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

    public void addStrength(int strength) {     //character`s strength value token + strength value to be added = new strength value
        this.setStrength(this.getStrength() + strength);
    }

    //witchcraft

    public int getWitchcraft() {
        return witchcraft;
    }

    public void setWitchcraft(int witchcraft) {
        this.witchcraft = witchcraft;
    }

    public void addWitchcraft(int witchcraft) {
        this.setWitchcraft(this.getWitchcraft() + witchcraft);
    }

    //willpower
    public int getWillpower() {
        return willpower;
    }

    public void setWillpower(int willpower) {
        this.willpower = willpower;
    }

    public void addWillpower(int willpower) {
        this.setWillpower(this.getWillpower() + willpower);
    }

    //wisdom
    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void addWisdom(int wisdom) {
        this.setWisdom(this.getWisdom() + wisdom);
    }

    public String getName() {
        return name;
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

    Screen gameOver = new Screen();

    String[] gameOverOutput = {


            "   ▄██████▄     ▄████████   ▄▄▄▄███▄▄▄▄      ▄████████       ▄██████▄   ▄█    █▄     ▄████████  ▄████████",
            "  ███    ███   ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███      ███    ███ ███    ███   ███    ███  ███    ███",
            "  ███    █▀    ███    ███ ███   ███   ███   ███    █▀       ███    ███ ███    ███   ███    █▀   ███    ███",
            "  ▄███         ███    ███ ███   ███   ███  ▄███▄▄▄          ███    ███ ███    ███  ▄███▄▄▄     ▄███▄▄▄▄██▀",
            "▀▀███ ████▄  ▀███████████ ███   ███   ███▀▀███▀▀▀           ███    ███ ███    ███ ▀▀███▀▀▀     ▀▀███▀▀▀▀▀",
            "  ███    ███   ███    ███ ███   ███   ███   ███    █▄       ███    ███ ███    ███   ███    █▄  ▀███████████",
            "  ███    ███   ███    ███ ███   ███   ███   ███    ███      ███    ███ ███    ███   ███    ███  ███    ███",
            "  ████████▀    ███    █▀   ▀█   ███   █▀    ██████████       ▀██████▀   ▀██████▀    ██████████  ███    ███",
                                                                                                            "███    ███" ,
    };

    public String[] getGameOver() {
        return gameOverOutput;

        //game over method
        //String spotwon --> als private in spot definiert

    /*Screen gameOver = new Screen();
        if (character.getHealth() < 0) {
        gameOver.append(StringTools.addPadding(spotwon, 112, 12));
    } else {
        gameOver.append(StringTools.addPadding(lostcastle, 112, 12));
    }
        renderer.printScreen(castle);
}*/
    }
}
