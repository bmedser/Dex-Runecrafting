package com.xcookie.rc.leaf.action;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.assets.Objects;

/**
 * NOTES:
 * Interact with the altar, Craft-rune
 */
public class CraftRunes extends LeafTask {

    private Objects objects;
    private GameObject altar;

    @Override
    public void execute() {
        altar = GameObjects.newQuery().ids(29631).on(new Coordinate(3059,5578,0)).results().first();
        if(!altar.isVisible()) {
            Camera.concurrentlyTurnTo(altar);
        }
        altar.interact("Craft-rune");
//        altar.click();
    }
}
