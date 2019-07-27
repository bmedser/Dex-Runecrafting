package com.xcookie.rc.leaf.traverse;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Path;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.location.navigation.basic.PredefinedPath;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.assets.Locations;
import com.xcookie.rc.assets.Objects;
import com.xcookie.rc.leaf.action.descendLadder;

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
        webPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(Locations.ZMIOutside);
//        paint image path -> setPathOutside.png
/*        pathToLadder.add(new Coordinate(2460,3250,0));
        pathToLadder.add(new Coordinate(2454,3243,0));
        pathToLadder.add(new Coordinate(2454,3232,0));
        PredefinedPath p = PredefinedPath.create(pathToLadder);*/

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



