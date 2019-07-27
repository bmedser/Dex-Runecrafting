package com.xcookie.rc.leaf.bank;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Health;
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

        if(Health.getCurrentPercent() <= 50) {
            if (Bank.isOpen() && Bank.contains("Salmon")) {
                Bank.withdraw("Salmon", 5);
            }
        }

        if (!Inventory.contains("Pure essence")) {
            if ( Bank.isOpen()) {
                Bank.withdraw("Pure essence", 28);
            } else {
                Bank.open();
            }
        }
    }
}
