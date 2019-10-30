package de.on19.mooscraft.game.characters;

public class Character {

    public int health;
    private int strength;
    private int witchcraft;
    private int willpower;
    private int wisdom;

    public Character() {
        this(0,0,0,0,0);
    }

    public Character(int health, int strength, int witchcraft, int willpower, int wisdom) {
        this.health = health;
        this.strength = strength;
        this.witchcraft = witchcraft;
        this.willpower = willpower;
        this.wisdom = wisdom;
    }

   public void setHealth(int health){
       this.health = health;
   }

    public int getHealth(){
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

    public void addStrength(int strength) {
        this.setStrength(this.getStrength() + strength);
    }

    // TODO andere Methoden hinzufügen
}
