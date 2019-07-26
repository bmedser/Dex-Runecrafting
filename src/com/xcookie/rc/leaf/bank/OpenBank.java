package com.xcookie.rc.leaf.bank;

import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.queries.BankQueryBuilder;
import com.runemate.game.api.hybrid.queries.results.LocatableEntityQueryResults;
import com.runemate.game.api.hybrid.region.Banks;
import com.runemate.game.api.hybrid.region.Npcs;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.assets.NPC;
import com.xcookie.rc.leaf.traverse.traverseEniola;

/**
 * NOTES:
 * Open Eniola's storage hole
 */
public class OpenBank extends LeafTask {

    private traverseEniola traverseeniola = new traverseEniola();
    private Npc eniolaNPC;
    @Override
    public void execute() {

        try {
            eniolaNPC = Npcs.newQuery().names("Eniola").ids(7417).on(NPC.bankCoord).results().first();
            if (eniolaNPC != null) {
                getLogger().debug("Eniola is in ram");
                if (!eniolaNPC.isVisible()) {
                    getLogger().warn("bank not visible");
                    Camera.concurrentlyTurnTo(eniolaNPC);
                }
                Bank.open(((LocatableEntityQueryResults)((BankQueryBuilder) Banks.newQuery().visible()).results()).nearest());
                Execution.delayUntil(Bank::isOpen, 1000, 2000);
                getLogger().debug("Opening Eniola's Hole");
            } else {
                new traverseEniola();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

       /* if (eliona != null && eniola.isVisible()) {
//            NPC.Eniola.interact("Bank");
            Execution.delayUntil(() -> !Bank.isOpen(), 1000, 4000);
            getLogger().info("Interacting with " + eniola.getName());
            Camera.concurrentlyTurnTo(eniola);
        } else {
            new traverseEniola();
        }*/
    }
}

