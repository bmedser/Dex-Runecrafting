package com.xcookie.rc.leaf.bank;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Health;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.Main;

import static com.runemate.game.api.hybrid.local.hud.interfaces.Bank.*;
import static com.runemate.game.api.hybrid.local.hud.interfaces.Bank.DefaultQuantity.ALL;

/**
 * NOTES:
 * Withdraw essence!
 */
public class WithdrawItems extends LeafTask {

    @Override
    public void execute() {
        new Main().setCurrentTaskString("Withdrawing items");
        getLogger().debug("Withdrawing items!");

        setDefaultQuantity(ALL);

        if (Health.getCurrentPercent() <= 50) {
            if (Bank.isOpen() && Bank.containsAnyOf("Salmon", "Shark", "Monkfish", "Lobster", "Swordfish")) {
                Bank.withdraw("Salmon", 5);
                Bank.withdraw("Shark", 5);
                Bank.withdraw("Monkfish", 5);
                Bank.withdraw("Lobster", 5);
                Bank.withdraw("Swordfish", 5);

            }
        }
/*
        if(Traversal.getRunEnergy() < 50 && !Traversal.isStaminaEnhanced()) {
            if(Bank.containsAnyOf("Stamina", "Energy")) {
//                Bank.withdraw("Stamina potion (4)", 1);
//                Bank.withdraw("Stamina potion (3)", 1);
//                Bank.withdraw("Stamina potion (2)", 1);
                Bank.withdraw("Stamina potion (1)", 1);
            }
        }
*/


        if (!Inventory.contains("Pure essence")) {
            if (Bank.isOpen()) {
                if (Traversal.getRunEnergy() < 70 && !Traversal.isStaminaEnhanced()) {
                    if (Bank.containsAnyOf(12631)) {
                        getLogger().fine("Withdrawing stamina pot");
                        Bank.withdraw("Stamina potion(1)", 1);
                    } else if (Bank.containsAnyOf(3008)) {
                        if(!Inventory.containsAnyOf("Energy potion")) {
                            getLogger().fine("Withdrawing energy pot");
                            Bank.withdraw("Energy potion(4)", 1);
                        }
                    } else if (Bank.containsAnyOf(3016)) {
                        if(!Inventory.containsAnyOf("Super energy")) {
                            getLogger().fine("Withdrawing super energy pot");
                            Bank.withdraw("Super energy(4)", 1);
                        }
                    }
                    Execution.delay(100,400,300);
                }
                Bank.withdraw("Pure essence", 28);
            } else {
                Bank.open();
            }
        }
    }
}
