package com.xcookie.rc.leaf.action;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
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

    @Override
    public void execute() {
        objects.ladderEntry.interact(action); //GameObject
        Execution.delayUntil(() -> !Players.getLocal().isMoving());
        getLogger().info("Trying to descend ladder");

    }
}
