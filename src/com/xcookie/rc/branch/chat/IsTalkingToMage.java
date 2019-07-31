package com.xcookie.rc.branch.chat;

import com.runemate.game.api.hybrid.local.hud.interfaces.ChatDialog;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xcookie.rc.leaf.action.descendLadder;
import com.xcookie.rc.leaf.traverse.traverseLadder;

public class IsTalkingToMage extends BranchTask {

    private descendLadder descendladder = new descendLadder();
    private traverseLadder traverseladder = new traverseLadder();

    @Override
    public boolean validate() {
        return ChatDialog.isOpen();
//        return ChatDialog.hasText("What's that ladder next to the ladder for?");
    }

    @Override
    public TreeTask successTask() {
        getLogger().warn("Player is talking to Mage of Zamorak!");
        return descendladder; //todo
    }

    @Override
    public TreeTask failureTask() {
        return descendladder;
    }

}
