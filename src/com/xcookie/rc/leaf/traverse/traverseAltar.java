package com.xcookie.rc.leaf.traverse;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.hud.interfaces.InterfaceComponent;
import com.runemate.game.api.hybrid.local.hud.interfaces.InterfaceWindows;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
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
import com.xcookie.rc.Main;
import com.xcookie.rc.assets.Locations;
import com.xcookie.rc.leaf.StopBot;

import java.util.List;

import static com.runemate.game.api.hybrid.local.hud.interfaces.Inventory.newQuery;

/**
 * NOTES:
 * Start walking to altar
 */
public class traverseAltar extends LeafTask {
    private Prayer prayer;
    private InterfaceComponent openQuickPrayerMenu;
    private RegionPath pathToAltar;
    private WebPath webPath;
    private GameObject altar = GameObjects.newQuery().ids(29631).on(new Coordinate(3059, 5578, 0)).results().nearest();
    private Path p;

    @Override
    public void execute() {
        new Main().setCurrentTaskString("Traversing to altar");

        if (altar == null)
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
            while (!Locations.ZMIRCAltar.contains(Players.getLocal())) {
                new Main().setCurrentTaskString("Traversing to Ourania altar");

                if (Traversal.getRunEnergy() <= 79) {
                    for (int doseSize = 1; doseSize <= 4; doseSize++) {
                        if (Inventory.containsAnyOf("Super energy(" + doseSize + ")", "Energy potion(" + doseSize + ")")) {
                            SpriteItem potion = Inventory.newQuery().names(
                                    "Super energy(" + doseSize + ")",
                                    "Energy potion(" + doseSize + ")"
                            ).actions("Drink").results().first();

//                                Execution.delayUntil(() -> InventoryE);

                            potion.interact("Drink");
                        }
                    }
                }

                //Protect from range //TODO:
                if (!Prayer.isQuickPraying()) {
                    List<Prayer> quickprayers = Prayer.getSelectedQuickPrayers();
                    if (!quickprayers.contains(Prayer.PROTECT_FROM_MISSILES) && !quickprayers.contains(Prayer.RAPID_HEAL)) {
                        if (!Prayer.isQuickPrayerSetupOpen()) {
                            //open quick prayers

                            Prayer.setQuickPrayers(Prayer.PROTECT_FROM_MISSILES, Prayer.RAPID_HEAL);
                            getLogger().debug("Trying to setup quick prayers");

                        } else { //its open, customise them
//                            Prayer.setQuickPrayers(Prayer.PROTECT_FROM_MISSILES, Prayer.RAPID_HEAL);
                            Prayer.confirmQuickPrayerSelection();
                        }
                    } else {
                        //if quick prayers already contain protect from range and rapid heal... activate!
                        Prayer.toggleQuickPrayers();
                    }
                }

/*                if (!Prayer.PROTECT_FROM_MISSILES.isActivated() || !Prayer.RAPID_HEAL.isActivated()) {
                    Prayer.PROTECT_FROM_MISSILES.activate();
                    Prayer.RAPID_HEAL.activate();
                }*/

                if (webPath != null)
                    webPath.step();
            }
        } catch (NullPointerException e) {
            getLogger().severe("Cant traverse altar! very bad!");
            e.printStackTrace();
        }
    }
}
