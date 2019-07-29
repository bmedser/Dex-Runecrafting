package com.xcookie.rc.leaf.traverse;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Path;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.osrs.local.hud.interfaces.Prayer;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.Main;
import com.xcookie.rc.assets.Locations;
import com.xcookie.rc.leaf.StopBot;

/**
 * NOTES:
 * Start walking to altar
 */
public class traverseAltar extends LeafTask {

    private RegionPath pathToAltar;
    private WebPath webPath;
    private GameObject altar;
    private Path p;

    @Override
    public void execute() {
        altar = GameObjects.newQuery().ids(29631).on(new Coordinate(3059, 5578, 0)).results().first();
        if(altar == null)
            altar = GameObjects.newQuery().ids(29631).on(new Coordinate(3059, 5578, 0)).results().first();

        webPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(Locations.ZMIRCAltar.getRandomCoordinate());

        try {

/*            if (altar != null) {
                webPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(Locations.ZMIRCAltar.getRandomCoordinate());
            } else {
                getLogger().warn("I couldn't find altar");
                new StopBot();
            }*/

            //Perform traversing

//            while (!new Area.Circular(Locations.ZMIRCAltar.getCenter(), 5).contains(Players.getLocal())) {
            while(!Locations.ZMIRCAltar.contains(Players.getLocal())) {
                new Main().setCurrentTaskString("Traversing to Ourania altar");

                //Protect from range //TODO:
                if(!Prayer.PROTECT_FROM_MISSILES.isActivated() && !Prayer.RAPID_HEAL.isActivated()) {
                    Prayer.PROTECT_FROM_MISSILES.activate();
                    Prayer.RAPID_HEAL.activate();
                }

                if(webPath != null)
                    webPath.step();
            }
        } catch (NullPointerException e) {
            getLogger().severe("Cant traverse altar! very bad!");
            e.printStackTrace();
        }
    }
}
