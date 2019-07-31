package com.xcookie.rc.leaf.action;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.Main;
import com.xcookie.rc.assets.Locations;

/**
 * NOTES:
 * Interact with the altar, Craft-rune
 */
public class CraftRunes extends LeafTask {

    private GameObject altar;
    private descendLadder descendladder = new descendLadder();

    @Override
    public void execute() {
        new Main().setCurrentTaskString("Crafting runes");


        altar = GameObjects.newQuery().ids(29631).on(new Coordinate(3059,5578,0)).results().first();
        if(!altar.isVisible()) {
            descendladder.hasPrayed = false;
/*            if (Locations.ZMIRCAltar.contains(Players.getLocal())) {
                new CraftRunes();
            }*/
/*            if(altar.distanceTo(Players.getLocal().getPosition()) < 7) {
                new CraftRunes();
            }*/
            Camera.concurrentlyTurnTo(altar);
        }

        if(altar.interact("Craft-rune")) { //reminder
            Execution.delay(150, 800, 360);
        }
    }
}
