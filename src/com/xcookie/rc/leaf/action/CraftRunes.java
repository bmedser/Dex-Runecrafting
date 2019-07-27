package com.xcookie.rc.leaf.action;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.assets.Locations;
import com.xcookie.rc.assets.Objects;

/**
 * NOTES:
 * Interact with the altar, Craft-rune
 */
public class CraftRunes extends LeafTask {

    private GameObject altar;

    @Override
    public void execute() {
        altar = GameObjects.newQuery().ids(29631).on(new Coordinate(3059,5578,0)).results().first();
        if(!altar.isVisible()) {
/*            if (Locations.ZMIRCAltar.contains(Players.getLocal())) {
                new CraftRunes();
            }*/
/*            if(altar.distanceTo(Players.getLocal().getPosition()) < 7) {
                new CraftRunes();
            }*/
            Camera.concurrentlyTurnTo(altar);
        }
        altar.interact("Craft-rune");
    }
}
