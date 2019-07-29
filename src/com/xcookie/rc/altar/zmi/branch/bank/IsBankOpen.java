package com.xcookie.rc.altar.zmi.branch.bank;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import com.xcookie.rc.altar.zmi.branch.inventory.IsInventoryEmpty;
import com.xcookie.rc.altar.zmi.branch.traverse.IsEniolaNearby;

/**
 * NOTES:
 * Is the bank open?
 */
public class IsBankOpen extends BranchTask {

    private IsInventoryEmpty isinventoryempty = new IsInventoryEmpty();
    private IsEniolaNearby iseniolanearby = new IsEniolaNearby();

    @Override
    public boolean validate() {
        getLogger().debug("Is bank open?");
        return Bank.isOpen();
    }

    @Override
    public TreeTask failureTask() {
        getLogger().debug("bank not open");
        return iseniolanearby;
    }

    @Override
    public TreeTask successTask() {
        getLogger().debug("bank is open with no required items");
        return isinventoryempty;
    }
}
