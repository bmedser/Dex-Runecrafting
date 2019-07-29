package com.xcookie.rc.altar.zmi.branch.traverse;

import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import com.xcookie.rc.assets.Locations;
import com.xcookie.rc.altar.zmi.branch.inventory.HasRequiredItems;

/**
 * NOTES:
 * Can i see altar
 */
public class IsInZMI extends BranchTask {

    private HasRequiredItems hasrequireditems = new HasRequiredItems();
    private IsLadderNearby isladdernearby = new IsLadderNearby();

    @Override
    public boolean validate() {
        getLogger().debug("isInZMI");
        return Locations.ZMIRoom.contains(Players.getLocal());
    }

    @Override
    public TreeTask failureTask() {
        return isladdernearby;
    }

    @Override
    public TreeTask successTask() {
        return hasrequireditems;
    }
}
