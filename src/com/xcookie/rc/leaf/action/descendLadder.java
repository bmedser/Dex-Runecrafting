package com.xcookie.rc.leaf.action;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.osrs.local.hud.interfaces.Prayer;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.Main;
import com.xcookie.rc.assets.Locations;
import com.xcookie.rc.assets.Objects;

/**
 * NOTES:
 * Climb down ladder
 */
public class descendLadder extends LeafTask {

    /*    public descendLadder(GameObject ladder, String action) {
            this.ladder = ladder;
            this.action = action;
        }*/
    private Objects objects;
    private final String action = "Climb";
    public static Coordinate ladderCoord = new Coordinate(2452 + 1, 3231, 0); // + 1 so i can walk there
    GameObject chaosAltar, ladder;
    public boolean hasPrayed = false;

    @Override
    public void execute() {
        new Main().setCurrentTaskString("Descending ladder");


        getLogger().debug("descend ladder");
        chaosAltar = GameObjects.newQuery().on(new Coordinate(2454, 3231, 0)).results().first();
        ladder = GameObjects.newQuery().on(new Coordinate(2452, 3231, 0)).actions("Climb").results().first();

        if(chaosAltar != null && Prayer.getPoints() < Prayer.getMaximumPoints() - 10/* && !hasPrayed*/) { //todo commented for now cause api fucked?
            if(!chaosAltar.isVisible()) {
                getLogger().debug("turning camera to altar");
                Camera.concurrentlyTurnTo(chaosAltar);
            }
            getLogger().info("Trying to pray at altar");
//            chaosAltar.interact("Pray-at");
//            Execution.delay(1000);
            if(chaosAltar.interact("Pray-at")) {
                Execution.delayUntil(() -> Prayer.getPoints() >= Prayer.getMaximumPoints() - 10 || Locations.ZMIRoom.contains(Players.getLocal()));
                hasPrayed = true;
            }
        }

        if (ladder != null) {
            if (!ladder.isVisible()) {
                getLogger().debug("turning camera to ladder");
                Camera.concurrentlyTurnTo(ladder);
                Camera.setZoom(0.1, 0.2);
            }
            getLogger().info("Trying to descend ladder");
            ladder.interact("Climb"); //fix todo
        }
    }
}