package com.xcookie.rc.leaf.action;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.osrs.local.hud.interfaces.Prayer;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.assets.Locations;
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
    public static Coordinate ladderCoord = new Coordinate(2452 +1 , 3231, 0); // + 1 so i can walk there
    GameObject chaosAltar, ladder;

    @Override
    public void execute() {
        chaosAltar = GameObjects.newQuery().on(new Coordinate(2454,3231,0)).results().first();
        ladder = GameObjects.newQuery().on(new Coordinate(2452,3231,0)).actions("Climb").results().nearest();

        //regain prayer points!
        if(Prayer.getPoints() < Prayer.getMaximumPoints() - 10) {
//            chaosAltar.click();
            chaosAltar.interact("Pray-at");
            Execution.delayUntil(() -> (Prayer.getPoints() >= Prayer.getMaximumPoints() - 5) ); //so if it lags or something it will still stop the delay
        }

        Execution.delayUntil(() -> !Players.getLocal().isMoving());
        if(ladder != null) {
            getLogger().info("Trying to descend ladder");
            ladder.click();
//            Execution.delayUntil( () -> Players.getLocal().getPosition().equals(new Coordinate(3015,5629,0)));
            Execution.delayUntil( () -> Players.getLocal().getAnimationId() != 827); //descend ladder animation
        }
//        objects.ladderEntry.interact(action); //GameObject

    }
}
