package com.xcookie.rc.leaf.action;

import com.runemate.game.api.hybrid.local.hud.interfaces.WorldHop;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class ChangeWorld extends LeafTask {
    @Override
    public void execute() {

        if(!WorldHop.isOpen()) {
            WorldHop.open();
            Execution.delayUntil(WorldHop::isOpen);
            WorldHop.hopTo(327);
        }

    }
}
