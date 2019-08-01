package com.xcookie.rc.branch;

import com.runemate.game.api.hybrid.local.Worlds;
import com.runemate.game.api.hybrid.local.hud.interfaces.WorldHop;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xcookie.rc.branch.traverse.IsInZMI;
import com.xcookie.rc.leaf.action.ChangeWorld;

public class IsOnWorld extends BranchTask {

    private IsInZMI isInZMI;
    private ChangeWorld changeWorld;

    @Override
    public boolean validate() {

        return (Worlds.getCurrent() == 327);
    }

    @Override
    public TreeTask successTask() {
        return isInZMI;
    }

    @Override
    public TreeTask failureTask() {
        return changeWorld;
    }


}
