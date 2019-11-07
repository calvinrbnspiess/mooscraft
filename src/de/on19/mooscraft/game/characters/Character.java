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

        /*constructor gives actual values to the parameters given to the variables before via Character constructor
         *this.  refers to class attributes
         */
    }

    public Character(String name) {
        this(0, 0, 0, 0, 0);
        this.setName(name);
    }
        /*
         * Methode verlangt Name als String Eingabe
         */

    public Character(int health, int strength, int witchcraft, int willpower, int wisdom) {
        this.name = "Unbekannter Spieler";
        /*constructor
         * gives basic values (in brackets) to the variables (called by this.)
         * folglich wird der oben verlangte den vom Konstruktor gesetzten Werten zugeordnet
         */
        this.health = health;
        /*this: refers to class declared before above (e.g. public int health)
         * only "health" without "this" just refers to parameters in brackets within this Method
         * folglich wird erst in der Charakter-Klasse aus dem Standartwert 0 ein brauchbarer int-Wert wenn die Methode augerufen wird
         * und dort dann inizialisiert wird
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
    //standartmäßig wird kein Icon ausgegeben da der Array null ist das Icon wird erst im String der Klasse eingebunden


    public int getHealth() { //no parameters necessary since there is only a return value and no value provided into a variable
        return health;
    }
    // die Methode ist lediglich dafür zuständig den Healthwert abzufragen aber wir brauchen ihn nicht als Rückgabewert

    /*
     * getter and setter methods are necessary to call them later in other classes and change values
     * therefore, they are public
     */

    //health
    public void setHealth(int health) {
        this.health = health;
        //void weil sie keinen Wert zurückliefert sondern ihn überprüft
        // setzt den health wert als int-wert

        if (this.health <= 0 && this.gameOverScreen != null) {
            this.gameOverScreen.print();
        }
        /*es wird überprüft ob der gesetzte Wert kleiner oder ungleich Null ist
        * und sollte dies der Fall sein dann wird in Folge dessen der Gameoverscreen ausgegeben
         */
    }

    public void addHealth(int health) {
        this.setHealth(this.getHealth() + health);
    }
    /* die add Health Methode setzt durch die set Health Methode den Wert als aktuellen Health
     * welcher sich ergibt wenn der vorher gemerkte Healthwert und der der addiert bzw. subtrahiert wird
     */


    //strength
    public int getStrength() {
        return strength;
    }
     // Methode gibt den aktuellen Strenght Wert zurück (zum abfragen)

    public void setStrength(int strength) {
        this.strength = strength;
    }
    // Methode nimmt sich den Strenght Wert vom Feld und setzt ihn als die Variable strenght


    public void addStrength(int strength) {     //character`s strength value token + strength value to be added = new strength value
        int strengthAfter = this.getStrength() + strength;
        if (strengthAfter < 0) {          // sobald der Wert unter 0 geht
            this.setStrength(0);          // wird er gleich 0 gesetzt (bei jedem Wert außer Health)
            return;
        }

        this.setStrength(strengthAfter);
    }

    /* diese Methode nimmt sich dann den aktuellen Strenght Wert der Gettermethode addiert den Wert der Settermethode
     * gibt das Ergebnis zurück und setzt den Wert der als Strenghtafter durch die setter methode
     */

    //witchcraft

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
    // der oben als String verlangte Name wird durch die Methode abgefragt und zurückgegeben

    public void setName(String name) {
        this.name = name;
    }

    // durch diese Methode wird der eigegebene abgefragte Name als Name gesetzt

    public void increaseVisitedSpots() {
        this.visitedSpots += 1;
    }

    // durch diese Methode wird jedesmal wenn ein Feld betreten wird die Anzahl der betretenen Felder um eins erhöht

    public int getVisitedSpots() {
        return visitedSpots;
    }

    // durch diese Methode wird der aktuelle Stand an betretenen Feldern zurück gegeben

    public GameOverScreen getGameOverScreen() {
        return this.gameOverScreen;
    }
    // die Variable die oben aufgerufen wird wird nun als GameOverScreen ausgegeben

    public void prepareGameOverScreen(GameOverScreen gameOverScreen) {
        this.gameOverScreen = gameOverScreen;
    }
    // Gameoverscreen wird vorbereitet
}
