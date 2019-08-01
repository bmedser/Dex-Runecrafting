package com.xcookie.rc.leaf.traverse;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.Main;
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
        new Main().setCurrentTaskString("Traversing to entrance");

        getLogger().info("traverse ladder");
        ladder = GameObjects.newQuery().on(new Coordinate(2452, 3231, 0)).results().nearest();

        webPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(Locations.ZMIOutside.getRandomCoordinate()); //todo added get random coord
        try {
//        	if(!Locations.ZMIRoom.contains ( Players.getLocal ()) || new Objects().ladderEntry.distanceTo ( Players.getLocal ().getPosition () )) {
            if (/*!Locations.ZMIOutside.contains(Players.getLocal()) &&*/ webPath.step() && webPath != null/*|| !ladder.isVisible()*/ ) { //todo: can be executed when in zmi room and null pointer
                Execution.delayUntil(() -> !Players.getLocal().isMoving());

            }
        } catch(NullPointerException e) {
            e.printStackTrace();
        }

    }
}



