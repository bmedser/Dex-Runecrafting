package com.xcookie.rc.branch.traverse;

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

    @Override
    public boolean validate() {
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
