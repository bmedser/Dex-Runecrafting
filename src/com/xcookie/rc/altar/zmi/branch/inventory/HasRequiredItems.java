package com.xcookie.rc.altar.zmi.branch.inventory;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import com.xcookie.rc.altar.zmi.branch.bank.IsBankOpen;
import com.xcookie.rc.altar.zmi.branch.bank.IsBankOpenHasRequired;

/**
 * NOTES:
 * Have required items in inventory?
 */
public class HasRequiredItems extends BranchTask {

    private IsBankOpen isbankopen = new IsBankOpen();
    private IsBankOpenHasRequired isBankOpenHasRequired = new IsBankOpenHasRequired();

    @Override
    public boolean validate() {
        getLogger().debug("Has required items?");
//        return Inventory.containsAnyOf(Items.requiredItems);
        return Inventory.contains("Pure essence");
    }

    @Override
    public TreeTask failureTask() {
        getLogger().warn("bot doesnt have required items in inventory!");
        return isbankopen;
    }

    @Override
    public TreeTask successTask() {
        getLogger().debug("bot has required items!");
        return isBankOpenHasRequired;
    }
}
