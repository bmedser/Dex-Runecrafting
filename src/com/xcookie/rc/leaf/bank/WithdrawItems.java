package com.xcookie.rc.leaf.bank;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.assets.Items;

import static com.runemate.game.api.hybrid.local.hud.interfaces.Bank.*;
import static com.runemate.game.api.hybrid.local.hud.interfaces.Bank.DefaultQuantity.ALL;

/**
 * NOTES:
 * Withdraw essence!
 */
public class WithdrawItems extends LeafTask {

    @Override
    public void execute() {
        getLogger().debug("Withdrawing items!");
        setDefaultQuantity(ALL);
//        setDefaultWithdrawQuantity(Bank.DefaultWithdrawQuantity.ALL);

//        Bank.withdraw("Pure essence", 2147483647);

        if (!Inventory.contains("Pure essence")) {
            if ( Bank.isOpen()) {
                Bank.withdraw("Pure essence", 28);
            } else {
                Bank.open();
            }
        }/* else {
            if (Bank.isOpen()) {
                Bank.close(); // we do this stuff outside of this class
            }
        }*/
    }
}
