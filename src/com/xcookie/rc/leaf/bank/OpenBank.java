package com.xcookie.rc.leaf.bank;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Interfaces;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.web.vertex_types.utilities.NpcBankVertex;
import com.runemate.game.api.hybrid.queries.NpcQueryBuilder;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Npcs;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.osrs.local.hud.interfaces.Prayer;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.assets.NPC;
import com.xcookie.rc.assets.Objects;
import com.xcookie.rc.leaf.traverse.traverseEniola;

/**
 * NOTES:
 * Open Eniola's storage hole
 */
public class OpenBank extends LeafTask {

    private traverseEniola traverseeniola = new traverseEniola();
    private GameObject elionaNPC;
    @Override
    public void execute() {

        try {
            elionaNPC = GameObjects.newQuery().names("Eliona").ids(7417).on(NPC.bankCoord).results().first();

//            if (Prayer.PROTECT_FROM_MISSILES.isActivated()) Prayer.PROTECT_FROM_MISSILES.deactivate(); //TODO: change to inventory tab?

            if (/*elionaNPC.isVisible() && */elionaNPC != null) {
                getLogger().debug("eliona is in ram");

                if (elionaNPC.isVisible()) {
                    getLogger().warn("bank not visible");
                    Camera.concurrentlyTurnTo(elionaNPC);
                }
                Bank.open();
                elionaNPC.click();
                Execution.delayUntil(Bank::isOpen, 1000, 2000);
                getLogger().debug("Opening Eliona's Hole");
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

