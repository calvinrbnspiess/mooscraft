package de.on19.mooscraft.game.characters;

public class Character {

    //overall declaration of variables and Methods --> initialization in single character classes
    public int health;
    private int strength;
    private int witchcraft;
    private int willpower;
    private int wisdom;

    public Character() {
        this(0,0,0,0,0);
        /**
         * constructor gives actual values to the parameters given to the variables before via Character constructor
         *this.  refers to class attributes
         */
    }

    public Character(int health, int strength, int witchcraft, int willpower, int wisdom) {
        /**constructor
         * gives basoc values (in brackets) to the variables (called by this.)
         */
        */
         */
        this.health = health;
        /**this: refers to class declared before above (e.g. public int health)
         * only "health" without "this" just refers to parameters in brackets within this Method
         */
        this.strength = strength;
        this.witchcraft = witchcraft;
        this.willpower = willpower;
        this.wisdom = wisdom;
    }

    /** getter and setter methods are necessary to call them later in other classes and change values
     * therefore, they are public
    */
   public void setHealth(int health){
       this.health = health;
   }

    public int getHealth(){ //no parameters necessary since there is only a return value and no value provided into a variable
        return health;
    }


    public void addHealth(int health) {
        this.setHealth(this.getHealth() + health);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void addStrength(int strength) {     //character`s strength value token + strength value to be added = new strength value

        this.setStrength(this.getStrength() + strength);
    }

    // TODO andere Methoden hinzufügen
}
