package com.xcookie.rc.altar.zmi.branch.inventory;

import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xcookie.rc.assets.Pouch;
import com.xcookie.rc.altar.zmi.branch.traverse.IsNearAltar;
import com.xcookie.rc.altar.zmi.leaf.inventory.FillPouch;

/**
 * NOTES:
 * Are pouches full?
 */
public class IsPouchesFull extends BranchTask {

    private IsNearAltar isnearaltar = new IsNearAltar();
    private FillPouch fillPouches;
    SpriteItem[] nig = new SpriteItem[3];
    Pouch pouch;

    public IsPouchesFull(){
        try {
//            SpriteItemQueryResults aye = Inventory.getItems("pouch").sortByIndex();
/*            for (int i = 0; i < 4; i++) {
                SpriteItem aye = Inventory.getItemIn(i);
                nig[i] = aye;
            }*/
/*            for (SpriteItem pouchIndex : aye) {
                fillPouches = new FillPouch(pouchIndex);
            }*/
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override //TODO
    public boolean validate() {

        return true;
    }

    @Override
    public TreeTask failureTask() {
        return fillPouches;
    }

    @Override
    public TreeTask successTask() {
        return isnearaltar;
    }
}
