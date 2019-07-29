package com.xcookie.rc.altar.zmi.leaf.inventory;

import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.script.framework.tree.LeafTask;

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
