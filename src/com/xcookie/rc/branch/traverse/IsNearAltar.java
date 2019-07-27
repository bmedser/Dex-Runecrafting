package com.xcookie.rc.branch.traverse;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import com.xcookie.rc.Main;
import com.xcookie.rc.assets.Locations;
import com.xcookie.rc.assets.Objects;
import com.xcookie.rc.branch.inventory.HasEssence;
import com.xcookie.rc.leaf.traverse.traverseAltar;

/**
 * NOTES:
 * Is next to altar?
 */
public class IsNearAltar extends BranchTask {

    private HasEssence hasessence = new HasEssence();
    private traverseAltar traversealtar = new traverseAltar();
    private Objects objects;
    private GameObject altar;

    @Override
    public boolean validate() {
        altar = GameObjects.newQuery().ids(29631).on(new Coordinate(3059,5578,0)).results().first();

//        if(altar != null && altar.getPosition() != null) {
//            return Locations.ZMIRCAltar.contains(Players.getLocal());
        return altar.isVisible();
//        }
//        return false;
    }

    @Override
    public TreeTask failureTask() {
        getLogger().info("running to altar");
        return traversealtar;
    }

    @Override
    public TreeTask successTask() {
        getLogger().debug("has essence?");
        return hasessence;
    }
}
