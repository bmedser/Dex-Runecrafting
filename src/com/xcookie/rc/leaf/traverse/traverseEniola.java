package com.xcookie.rc.leaf.traverse;

import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.osrs.local.hud.interfaces.Prayer;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.assets.Locations;

/**
 * NOTES:
 * Walk to bank
 */
public class traverseEniola extends LeafTask {

    private RegionPath pathToEniola;

    @Override
    public void execute() {
        pathToEniola = RegionPath.buildTo(Locations.ZMIBank);
        pathToEniola.step();
        //Protect from range //TODO:
//        Prayer.PROTECT_FROM_MISSILES.activate();

        //run to eniola
/*        if (pathToEniola.step()) {
            Execution.delayUntil(() -> !Players.getLocal().);
        }*/
    }
}
