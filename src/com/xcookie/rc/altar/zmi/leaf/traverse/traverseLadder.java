package com.xcookie.rc.altar.zmi.leaf.traverse;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.assets.Locations;
import com.xcookie.rc.assets.Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * NOTES:
 * Run to the ladder
 */
public class traverseLadder extends LeafTask {

    Objects objects;
    WebPath webPath;
    List<Coordinate> pathToLadder = new ArrayList<Coordinate>();
    GameObject ladder;

    @Override
    public void execute() {
        getLogger().info("traverse ladder");
        ladder = GameObjects.newQuery().on(new Coordinate(2452, 3231, 0)).results().nearest();

//        Path p = BresenhamPath.buildTo(Locations.ZMIWorldLadder); //would run around the ladder and look suspicious af
        webPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(Locations.ZMIOutside.getRandomCoordinate()); //todo added get random coord

/*        if (Locations.ZMIOutside.contains(Players.getLocal())) { //TODO: this is a duplicated thing
            new descendLadder(objects.ladderEntry, "Climb");
        }*/

        if (!Locations.ZMIOutside.contains(Players.getLocal()) || !ladder.isVisible()) {
            if (webPath.step()) { //faster running
                Execution.delayUntil(() -> !Players.getLocal().isMoving());
            }
        }
    }
}



