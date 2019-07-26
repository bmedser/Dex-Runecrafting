package com.xcookie.rc.branch.inventory;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import com.xcookie.rc.branch.bank.DoesBankHaveRequiredItems;
import com.xcookie.rc.leaf.bank.DespositAll;


/**
 * NOTES:
 * 
 */
public class IsInventoryEmpty extends BranchTask {

    private DoesBankHaveRequiredItems doesbankhaverequireditems = new DoesBankHaveRequiredItems();
    private DespositAll despositall = new DespositAll();

    @Override
    public boolean validate() {
        getLogger().debug("is inventory empty");
//        return Inventory.isEmpty();
        return !Inventory.containsAnyOf("rune");

    }

    @Override
    public TreeTask failureTask() {
        getLogger().debug("failed, desposit all");
        return despositall;
    }

    @Override
    public TreeTask successTask() {
        return doesbankhaverequireditems;
    }
}
