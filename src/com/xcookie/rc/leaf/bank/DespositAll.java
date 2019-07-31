package com.xcookie.rc.leaf.bank;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.Main;

/**
 * NOTES:
 * Desposit all items
 */
public class DespositAll extends LeafTask {

    @Override
    public void execute() { //TODO
        new Main().setCurrentTaskString("Depositing items");

        getLogger().debug("Desposited all inventory");
//        Bank.depositAllExcept(Items.getIds(pouches));
        Bank.depositInventory();
    }
}
