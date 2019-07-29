package com.xcookie.rc.altar.zmi.leaf.inventory;

import com.runemate.game.api.hybrid.input.Keyboard;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.script.framework.tree.LeafTask;

import java.awt.event.KeyEvent;

/**
 * NOTES:
 * Empty whatever pouch, gimme that essence
 */
public class EmptyPouch extends LeafTask {

    private SpriteItem pouch;

    public EmptyPouch(SpriteItem pouch) {
        this.pouch = pouch;
    }

    @Override
    public void execute() {
        shiftInteract(pouch);
    }

    void shiftInteract(SpriteItem item) { //TODO: move to a better location and add sleep intervals?
        Keyboard.pressKey(KeyEvent.VK_SHIFT);
        item.click();
        Keyboard.releaseKey(KeyEvent.VK_SHIFT);
    }

}
