package de.on19.mooscraft.game.characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Character {
    public static void main(String[] args) {
        List<String> characters = new ArrayList<String>();
        characters.add("Hexe Magalia");
        characters.add("Kriegerin (Bellatrix)");
        characters.add("weißer Magier Kelii");
        characters.add("Schurke (Bandito)");
        characters.add("Meerjungfraumann ( Marin)");
        Scanner scan = new Scanner(System.in);
        System.out.println("Wähle deinen Spielcharakter aus und tippe den Charakternamen ein");
        String choice = scan.next();
        System.out.println("Du betrittst Mooscraft als " + choice);
    }


    }
