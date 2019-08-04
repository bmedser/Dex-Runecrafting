package com.xcookie.rc.leaf.inventory;

import com.runemate.game.api.hybrid.local.hud.interfaces.Chatbox;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.hybrid.queries.SpriteItemQueryBuilder;
import com.runemate.game.api.hybrid.queries.results.SpriteItemQueryResults;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.Main;
import com.xcookie.rc.assets.Pouch;
import com.xcookie.rc.branch.inventory.IsPouchesFull;

/**
 * NOTES:
 * Used to be withdraw items, now fill pouches
 */
public class FillPouch extends LeafTask {

    private SpriteItem pouch;
    Pouch pouchEnum;
    private IsPouchesFull isPouchesFull = new IsPouchesFull();

//    public FillPouch(SpriteItem pouch) {
//        this.pouch = pouch;
//    }

/*    public FillPouch() {

    }*/

    private SpriteItemQueryBuilder getPouches() {
        SpriteItemQueryBuilder pouches = Inventory.newQuery().actions("Fill", "Empty");
//        SpriteItemQueryResults pouchResults = pouches.results().sortByIndex();
        return pouches;
    }

    @Override
    public void execute() {

        SpriteItem tempPouch = getPouches().results().first();

        if(tempPouch != null)
            if(tempPouch.interact("Fill")) {
//                pouchEnum.setPouchFilled(Pouch.);
                
                switch(tempPouch.getId()) {
                    case 5514:
                        Pouch.GIANT_POUCH.setFull(true);
                        break;
                    case 5512:
                        Pouch.LARGE_POUCH.setFull(true);
                        break;
                    case 5510:
                        Pouch.MEDIUM_POUCH.setFull(true);
                        break;
                    case 5509:
                        Pouch.SMALL_POUCH.setFull(true);
                        break;
                }

                getLogger().debug("trying to fill " + pouch.toString());
                Execution.delayUntil( () -> !pouch.isValid());
            }

       /* for (Pouch pouches: Pouch.values()) {
            if(!pouches.isFull()) {
                isPouchesFull.totalPouches++;
                pouch = new SpriteItem(pouches.getIds(), 1);
                SpriteItem poouch = SpriteItemQueryBuilder.actions("Fill");
            }
            getLogger().debug("trying to fill " + pouch.toString());
        }*/

        new Main().setCurrentTaskString("Filling pouch");

//        pouch.interact("Fill");
//        Execution.delayUntil( () -> !pouch.isValid());
/*        SpriteItem[] pouchCount = Inventory.getItems().toArray();
        for(SpriteItem s : pouchCount ) {

        }*/
    }
}
