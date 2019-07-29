package com.xcookie.rc.altar.zmi.leaf.bank;

import com.runemate.game.api.hybrid.input.Keyboard;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;

import java.awt.event.KeyEvent;

/**
 * NOTES:
 * Is bank open?
 */
public class CloseBank extends LeafTask {

    @Override
    public void execute() {
        Bank.close(Keyboard.pressKey(KeyEvent.VK_ESCAPE));
    }
}
