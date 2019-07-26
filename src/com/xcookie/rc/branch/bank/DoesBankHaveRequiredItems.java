package com.xcookie.rc.branch.bank;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xcookie.rc.assets.Items;
import com.xcookie.rc.leaf.StopBot;
import com.xcookie.rc.leaf.bank.WithdrawItems;


/**
 * NOTES:
 * Check if the bank has the required items
 */
public class DoesBankHaveRequiredItems extends BranchTask {

    private WithdrawItems withdrawitems = new WithdrawItems();
    private StopBot stopbot = new StopBot();

    @Override
    public boolean validate() {
        getLogger().debug("does bank have required items?");
        return Inventory.contains(Items.pureEss.getId());
    }

    @Override
    public TreeTask failureTask() {
        getLogger().severe("bank doesnt have required items!");
        return stopbot;
    }

    @Override
    public TreeTask successTask() {
        getLogger().debug("has required items, try to withdraw");
        return withdrawitems;
    }
}
