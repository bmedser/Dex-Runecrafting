package com.xcookie.rc;

import com.runemate.game.api.hybrid.local.hud.interfaces.Health;
import com.runemate.game.api.hybrid.player_sense.PlayerSense;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xcookie.rc.branch.IsOnWorld;
import com.xcookie.rc.branch.traverse.IsInZMI;
import com.xcookie.rc.branch.traverse.IsLadderNearby;
import com.xcookie.rc.leaf.action.HpLow;


/**
 * NOTES:
 * This is the root node.

Add children of this branch using the settings to the right.
Always return true
 */
public class Root extends BranchTask {

    private IsInZMI isinzmi = new IsInZMI();
    private IsOnWorld hop = new IsOnWorld();
    private IsLadderNearby isLadderNearby = new IsLadderNearby();
    private HpLow hplow = new HpLow();

    @Override
    public boolean validate() {
        //if player health above 25, continue with script, other wise just stand still
        return Health.getCurrentPercent() >= 25;
    }

    @Override
    public TreeTask failureTask() {
        return hplow;
    }

    @Override
    public TreeTask successTask() {
        return isinzmi; //todo fix so does world hop
    }
}
