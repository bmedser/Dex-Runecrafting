package com.xcookie.rc.branch.inventory;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import com.xcookie.rc.assets.Items;
import com.xcookie.rc.branch.inventory.IsPouchesEmpty;
import com.xcookie.rc.leaf.action.CraftRunes;

/**
 * NOTES:
 * Are there essence in inventory?
 */
public class HasEssence extends BranchTask {
    
    private CraftRunes craftrunes = new CraftRunes();
    private IsPouchesEmpty ispouchesempty = new IsPouchesEmpty();

    @Override
    public boolean validate() {
//        return Inventory.contains(Items.pureEss.getId());
        return true;
//        return false;
    }

    @Override
    public TreeTask failureTask() {
        return ispouchesempty;
    }

    @Override
    public TreeTask successTask() {
        return craftrunes;
    }
}
