package com.xcookie.rc.leaf.traverse;

import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.local.Skills;
import com.runemate.game.api.hybrid.local.hud.interfaces.InterfaceComponent;
import com.runemate.game.api.hybrid.local.hud.interfaces.InterfaceWindows;
import com.runemate.game.api.hybrid.local.hud.interfaces.Openable;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.osrs.local.RunePouch;
import com.runemate.game.api.osrs.local.hud.interfaces.Magic;
import com.runemate.game.api.osrs.local.hud.interfaces.Prayer;
import com.runemate.game.api.rs3.local.hud.Powers;
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

        if(Skill.MAGIC.getCurrentLevel() >= 71) // TODO: add toggle for 'has runes for teleporting to ourania'
        {
            getLogger().debug("trying to check for magic stuffs");
            if(!InterfaceWindows.getMagic().isOpen()) {
                InterfaceWindows.getMagic().open();
            } else {
                Magic.Lunar.OURANIA_TELEPORT.activate();
                getLogger().debug("Using magic " + Magic.Lunar.OURANIA_TELEPORT.toString());
            }

        } else {
            pathToEniola = RegionPath.buildTo(Locations.ZMIBank);
            pathToEniola.step();

            while (new Area.Circular(Locations.ZMIBank.getCenter(), 5).contains(Players.getLocal())) {
                //Protect from range //TODO:
        //        Prayer.PROTECT_FROM_MISSILES.activate();
                pathToEniola.step();
            }

/*        if (pathToEniola.step()) {
            Execution.delayUntil(() -> new Area.Circular(Locations.ZMIBank.getCenter(), 5).contains(Players.getLocal()));
        }*/




            //run to eniola
/*        if (pathToEniola.step()) {
            Execution.delayUntil(() -> !Players.getLocal().);
        }*/
        }
    }
}
