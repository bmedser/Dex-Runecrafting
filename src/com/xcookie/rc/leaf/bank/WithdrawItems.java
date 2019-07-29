package com.xcookie.rc.leaf.bank;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Health;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.LeafTask;

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
            if (Bank.isOpen() && Bank.containsAnyOf("Salmon", "Shark", "Monkfish", "Lobster", "Swordfish")) {
                Bank.withdraw("Salmon", 5);
                Bank.withdraw("Shark", 5);
                Bank.withdraw("Monkfish", 5);
                Bank.withdraw("Lobster", 5);
                Bank.withdraw( "Swordfish", 5);

            }
        }

        if(Traversal.getRunEnergy() < 50 && Traversal.isStaminaEnhanced()) {
            if(Bank.containsAnyOf("Stamina", "Energy")) {
                Bank.withdraw("Stamina potion (4)", 1);
                Bank.withdraw("Stamina potion (3)", 1);
                Bank.withdraw("Stamina potion (2)", 1);
                Bank.withdraw("Stamina potion (1)", 1);
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
