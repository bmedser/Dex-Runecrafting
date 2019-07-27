package com.xcookie.rc.leaf.traverse;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Path;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.osrs.local.hud.interfaces.Prayer;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.assets.Locations;
import com.xcookie.rc.assets.Objects;
import com.xcookie.rc.leaf.action.CraftRunes;

/**
 * NOTES:
 * Start walking to altar
 */
public class traverseAltar extends LeafTask {

    private RegionPath pathToAltar;
    private WebPath webPath;
    private GameObject altar;

    @Override
    public void execute() {
        altar = GameObjects.newQuery().ids(29631).on(new Coordinate(3059, 5578, 0)).results().first();
        try {

            if (altar != null)
                webPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(Locations.ZMIRCAltar);
            else
                getLogger().warn("I couldn't find altar");

            while (!new Area.Circular(Locations.ZMIRCAltar.getCenter(), 2).contains(Players.getLocal())) {
                //Protect from range //TODO:
                if(!Prayer.PROTECT_FROM_MISSILES.isActivated() && !Prayer.RAPID_HEAL.isActivated()) {
                    Prayer.PROTECT_FROM_MISSILES.activate();
                    Prayer.RAPID_HEAL.activate();
                }
                webPath.step();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
