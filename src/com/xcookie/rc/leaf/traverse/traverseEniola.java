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
import com.xcookie.rc.leaf.StopBot;

/**
 * NOTES:
 * Walk to bank
 */
public class traverseEniola extends LeafTask {

    private RegionPath pathToEniola;

    @Override
    public void execute() {

        if(Skill.MAGIC.getCurrentLevel() >= 71 && Locations.ZMIRoom.contains(Players.getLocal())) {// TODO: add toggle for 'has runes for teleporting to ourania'
            //If magic window isnt open, open it!
            if(!InterfaceWindows.getMagic().isOpen()) {
                InterfaceWindows.getMagic().open();
            } else {
                //If magic window is open, teleport out of zmi!!
                if(!Locations.ZMITeleportArea.contains(Players.getLocal()))
                    Magic.Lunar.OURANIA_TELEPORT.activate();
                Execution.delay(500,1000);
//                Execution.delayUntil(() -> Locations.ZMITeleportArea.contains(Players.getLocal()));
                getLogger().info("Using spell: " + Magic.Lunar.OURANIA_TELEPORT.toString());
            }

        } else if(Locations.ZMIRoom.contains(Players.getLocal())){
            //Manually walk back to bank, used by skillers and low leveled players...
            try {
                pathToEniola = RegionPath.buildTo(Locations.ZMIBank);

                if (pathToEniola.step()) {
                    //so it doesnt run around the entire zmi ladder and look obv like a bot...
                    Execution.delayUntil(() -> !Players.getLocal().isMoving());
                }

                while (new Area.Circular(Locations.ZMIBank.getCenter(), 5).contains(Players.getLocal())) {
                    //Protect from range //TODO:
                    Prayer.PROTECT_FROM_MISSILES.activate();
                    pathToEniola.step();
                }
            }catch(NullPointerException e) {e.printStackTrace();}

        } else {
            getLogger().severe("Where the fuck is the player?\n Stopping bot!!!"); //todo
            new StopBot();
        }
    }
}
