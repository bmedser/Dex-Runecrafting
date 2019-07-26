package com.xcookie.rc.leaf.traverse;

import com.runemate.game.api.hybrid.location.navigation.Path;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.assets.Locations;
import com.xcookie.rc.assets.Objects;
import com.xcookie.rc.leaf.action.descendLadder;

/**
 * NOTES:
 * Run to the ladder
 */
public class traverseLadder extends LeafTask {

    Objects objects;

    @Override
    public void execute() {
        Path p = BresenhamPath.buildTo(Locations.ZMIWorldLadder);

/*        if (Locations.ZMIOutside.contains(Players.getLocal())) { //TODO: this is a duplicated thing
            new descendLadder(objects.ladderEntry, "Climb");
        }*/

        if (p.step()) { //faster running
            Execution.delayUntil(() -> !Players.getLocal().isMoving());
        }
    }
}

