package de.on19.mooscraft.game.worlds.world1;

import de.on19.mooscraft.game.screens.ChooseScreen;
import de.on19.mooscraft.game.worlds.Spot;
import de.on19.mooscraft.game.worlds.World;

import java.util.Collections;
import java.util.List;

public class World1 extends World {


    public World1() {
        super();

        //this.getSpots().add(new Spot1());
        // ... 6

        Collections.shuffle(this.getSpots());

        // TODO

//        int half = this.getSpots().size();
//        if (this.getSpots().size() % 2 == 0) {
//            half = half / 2;
//        } else {
//            half = ;
//        }

        List<Spot> path1 = this.getSpots().subList(0, 2);
        List<Spot> path2 = this.getSpots().subList(3, 5);

        ChooseScreen screen = new ChooseScreen();
        screen.appendLine("Weltbeschreibung");
        screen.addOptions(new String[] {
                "Erster Weg",
                "Zweiter Weg"
        });

        screen.addInstruction("Triff eine weise Entscheidung und wähle einen Weg zu deinem Gunsten.");

    }

}
