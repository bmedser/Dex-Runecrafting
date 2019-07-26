package com.xcookie.rc.branch.bank;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xcookie.rc.branch.inventory.IsInventoryEmpty;
import com.xcookie.rc.branch.inventory.IsPouchesFull;
import com.xcookie.rc.leaf.bank.CloseBank;

/**
 * NOTES:
 * Is the bank open?
 */
public class IsBankOpenHasRequired extends BranchTask {

    private CloseBank closeBank = new CloseBank();
    private IsPouchesFull isPouchesFull = new IsPouchesFull();

    @Override
    public boolean validate() {
        getLogger().debug("is bank open and has required items");
        return Bank.isOpen();
    }

    @Override
    public TreeTask failureTask() {
        return isPouchesFull;
    }

    @Override
    public TreeTask successTask() {
        return closeBank;
    }
}
