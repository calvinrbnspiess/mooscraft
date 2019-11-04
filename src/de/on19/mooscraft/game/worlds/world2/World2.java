package de.on19.mooscraft.game.worlds.world2;

import de.on19.mooscraft.game.worlds.World;
import de.on19.mooscraft.game.worlds.world1.Spot1;
import de.on19.mooscraft.utils.StringTools;

public class World2 extends World {

    public World2() throws UnsupportedOperationException {
        super(new String[]{       StringTools.wrapToLength("Langsam erreichst du den bekanntesten Fluss in ganz Mooscraft. Die Mittelklinge ist nicht nur Dank ihrem Namen sehr furchteinflößend. Pass gut auf, dass du nicht von einen der Stromstellen mitgerissen wirst. Um im Wasser zu überleben, braucht es höchste Konzentration und eine innere Ruhe. Bereite dich gut auf den nächsten Abschnitt deiner Reise vor und sie auf jede Gefahr gefasst.", 112),
                        "",
},
                "Wähle einen Weg.");

        super.getSpotsPool().add(new Spot1(this));
        super.getSpotsPool().add(new Spot1(this));
        super.getSpotsPool().add(new Spot1(this));

        super.getSpotsPool().add(new Spot1(this));
        super.getSpotsPool().add(new Spot1(this));
        super.getSpotsPool().add(new Spot1(this));

        // add all 6 spots
        super.generatePath("Den linken Wege musste gehen");
        super.generatePath(
                "Nur wer sein Ziel kennt, findet diesen Weg.");
    }

}

