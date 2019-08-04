package com.xcookie.rc.branch.traverse;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xcookie.rc.assets.Locations;
import com.xcookie.rc.branch.chat.IsTalkingToMage;
import com.xcookie.rc.leaf.action.descendLadder;
import com.xcookie.rc.leaf.traverse.traverseLadder;


/**
 * NOTES:
 * Is the ladder near the player?
 */
public class IsLadderNearby extends BranchTask {

    private traverseLadder traverseladder = new traverseLadder();
    private IsTalkingToMage isTalkingToWizard = new IsTalkingToMage();
    GameObject chaosAltar = GameObjects.newQuery().on(new Coordinate(2454, 3231, 0)).results().first();
    GameObject ladder = GameObjects.newQuery().on(new Coordinate(2452, 3231, 0)).results().nearest();;

    @Override
    public boolean validate() {
        ladder = GameObjects.newQuery().on(new Coordinate(2452, 3231, 0)).results().nearest();
        chaosAltar = GameObjects.newQuery().on(new Coordinate(2454, 3231, 0)).results().first();

//        return ladder.isVisible();
            return Locations.ZMIOutside.contains(Players.getLocal());
    }

    @Override
    public TreeTask failureTask() {
        return traverseladder;
    }

    @Override
    public TreeTask successTask() { //TODO: fix make a call not new
        return isTalkingToWizard;
    }
}
