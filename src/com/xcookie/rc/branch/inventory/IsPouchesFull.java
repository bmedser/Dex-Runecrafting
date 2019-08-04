package com.xcookie.rc.branch.inventory;

import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xcookie.rc.assets.Pouch;
import com.xcookie.rc.branch.traverse.IsNearAltar;
import com.xcookie.rc.leaf.inventory.FillPouch;

/**
 * NOTES:
 * Are pouches full?
 */
public class IsPouchesFull extends BranchTask {

    private IsNearAltar isnearaltar = new IsNearAltar();
    private Pouch pouch;
    private FillPouch fillPouches;
    SpriteItem[] nig = new SpriteItem[3];

    public int totalPouches = 0;
//    Pouch pouch;

/*
    public IsPouchesFull(){
//        totalPouches = 0;

        try {

*/
/*            for (Pouch pouches: Pouch.values()) {
                if(!pouches.isFull()) {
                    totalPouches++;
                    new FillPouch(new SpriteItem(pouches.getIds(), 1));
                }
            }*//*


//            SpriteItemQueryResults aye = Inventory.getItems("pouch").sortByIndex();
*/
/*            for (int i = 0; i < 4; i++) {
                SpriteItem aye = Inventory.getItemIn(i);
                nig[i] = aye;
            }*//*

*/
/*            for (SpriteItem pouchIndex : aye) {
                fillPouches = new FillPouch(pouchIndex);
            }*//*




        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
*/

    @Override //TODO
    public boolean validate() {

        //if all avaliable pouches are full, return true! otherwise fill all them
//        return totalPouches >= 4;
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
