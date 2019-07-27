package com.xcookie.rc.branch.traverse;

import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.queries.NpcQueryBuilder;
import com.runemate.game.api.hybrid.region.Npcs;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.osrs.local.hud.interfaces.Prayer;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xcookie.rc.assets.NPC;
import com.xcookie.rc.assets.Objects;
import com.xcookie.rc.leaf.bank.OpenBank;
import com.xcookie.rc.leaf.traverse.traverseEniola;


/**
 * NOTES:
 * Is eniola close to the player
 */
public class IsEniolaNearby extends BranchTask {

    private OpenBank openbank = new OpenBank();
    private traverseEniola traverseeniola = new traverseEniola();
    private Objects objects;
//    private NPC npc;


    @Override
    public boolean validate() {
        getLogger().debug("is eniola nearby?");
//        npc = Npcs.newQuery().filter(npc -> npc.getDefinition() != null && npc.getDefinition().getId() == 7417);
//        if(npc.Eniola == null)
            return new Area.Circular(NPC.bankCoord, 15).contains(Players.getLocal());
//        return false;
    }

    @Override
    public TreeTask failureTask() {
        getLogger().warn("Trying to walk to eniola");
        return traverseeniola;
    }

    @Override
    public TreeTask successTask() {
        getLogger().debug("opening bank");
        return openbank;
    }
}
