package com.xcookie.rc.leaf.bank;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.assets.Items;

import static com.xcookie.rc.assets.Items.getIds;
import static com.xcookie.rc.assets.Items.pouches;

/**
 * NOTES:
 * Desposit all items
 */
public class DespositAll extends LeafTask {

    @Override
    public void execute() { //TODO
        getLogger().debug("Desposited all inventory");
//        Bank.depositAllExcept(Items.getIds(pouches));
        Bank.depositInventory();
    }
}
