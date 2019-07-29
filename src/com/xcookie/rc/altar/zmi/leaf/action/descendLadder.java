package com.xcookie.rc.altar.zmi.leaf.action;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.assets.Objects;

/**
 * NOTES:
 * Climb down ladder
 */
public class descendLadder extends LeafTask {

    /*    public descendLadder(GameObject ladder, String action) {
            this.ladder = ladder;
            this.action = action;
        }*/
    private Objects objects;
    private final String action = "Climb";
    public static Coordinate ladderCoord = new Coordinate(2452 + 1, 3231, 0); // + 1 so i can walk there
    GameObject chaosAltar, ladder;

    @Override
    public void execute() {
        getLogger().debug("descend ladder");
        chaosAltar = GameObjects.newQuery().on(new Coordinate(2454, 3231, 0)).results().first();
        ladder = GameObjects.newQuery().on(new Coordinate(2452, 3231, 0)).actions("Climb").results().first();




        if (ladder != null) {
            if (!ladder.isVisible()) {
                getLogger().debug("turning camera to ladder");
                Camera.concurrentlyTurnTo(ladder);
            }
            getLogger().info("Trying to descend ladder");
            ladder.interact("Climb"); //fix todo
        }
    }
}