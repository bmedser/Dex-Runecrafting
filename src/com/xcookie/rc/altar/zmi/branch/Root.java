package com.xcookie.rc.altar.zmi.branch;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xcookie.rc.altar.zmi.branch.traverse.IsInZMI;
import com.xcookie.rc.altar.zmi.branch.traverse.IsLadderNearby;


/**
 * NOTES:
 * This is the root node.

Add children of this branch using the settings to the right.
Always return true
 */
public class Root extends BranchTask {

    private IsInZMI isinzmi = new IsInZMI();
    private IsLadderNearby isLadderNearby = new IsLadderNearby();

    @Override
    public boolean validate() {
         // so it can get past login and shit
        getLogger().debug("Root");
        return true;
    }

    @Override
    public TreeTask failureTask() {
        return isLadderNearby;
    }

    @Override
    public TreeTask successTask() {
        return isinzmi;
    }
}
