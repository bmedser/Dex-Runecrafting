package com.xcookie.rc.altar.zmi.leaf.bank;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;

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
