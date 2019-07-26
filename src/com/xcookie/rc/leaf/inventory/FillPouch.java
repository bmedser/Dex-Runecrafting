package com.xcookie.rc.leaf.inventory;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.hybrid.queries.SpriteItemQueryBuilder;
import com.runemate.game.api.hybrid.queries.results.SpriteItemQueryResults;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.assets.Items;

/**
 * NOTES:
 * Used to be withdraw items, now fill pouches
 */
public class FillPouch extends LeafTask {

    private SpriteItem pouch;

    public FillPouch(SpriteItem pouch) {
        this.pouch = pouch;
    }

    @Override
    public void execute() {
        pouch.interact("Fill");
/*        SpriteItem[] pouchCount = Inventory.getItems().toArray();
        for(SpriteItem s : pouchCount ) {

        }*/
    }
}
