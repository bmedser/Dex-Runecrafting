package com.xcookie.rc.leaf.traverse;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Path;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
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
    private WebPath webPath;
    private Path pathToAltar;
    private Objects objects;
    private GameObject altar;
    @Override
    public void execute() {
        altar = GameObjects.newQuery().ids(29631).on(new Coordinate(3059,5578,0)).results().first();
        try {
            if (altar != null)
//            pathToAltar = RegionPath.buildTo(Locations.ZMIRCAltar);
//            pathToAltar = BresenhamPath.buildTo(Locations.ZMIWorldLadder);
                webPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(Locations.ZMIRCAltar);
            else
                geLogger().warn("I couldn't find altar");

            if (Locations.ZMIRCAltar.contains(Players.getLocal())) {
                new CraftRunes();
            }
//        if (pathToAltar != null && pathToAltar.step()) { //maybe have nested if
            if (webPath != null && !Locations.ZMIRCAltar.contains(Players.getLocal())) {
                if (webPath.step()) { //maybe have nested if
                    Execution.delayUntil(() -> !Players.getLocal().isMoving());
                }
            } else {
                getLogger().severe("cant step to altar");
            }
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }


        //Move camera towards altar within range of x

    }
}
