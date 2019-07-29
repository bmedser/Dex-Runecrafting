package com.xcookie.rc.altar.zmi.branch.inventory;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xcookie.rc.altar.zmi.leaf.inventory.EmptyPouch;
import com.xcookie.rc.altar.zmi.leaf.traverse.traverseEniola;

/**
 * NOTES:
 * Check if empty
 */
public class IsPouchesEmpty extends BranchTask {

    private traverseEniola traverseeniola = new traverseEniola();
//    private EmptyPouch emptypouch;
    private EmptyPouch emptypouch = new EmptyPouch(Inventory.getItemIn(0));

    public IsPouchesEmpty() {
/*        for(int pouchIndex : Items.pouchIds){
            emptypouch  = new EmptyPouch(Items.pouches[pouchIndex]);
        }*/
    }

    @Override //TODO
    public boolean validate() {
        return false;
    }

    @Override
    public TreeTask failureTask() {
        return emptypouch;
    }

    @Override
    public TreeTask successTask() {
        return traverseeniola;
    }
}
