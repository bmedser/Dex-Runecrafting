package com.xcookie.rc.leaf.action;

import com.runemate.game.api.hybrid.local.hud.interfaces.WorldHop;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class ChangeWorld extends LeafTask {
    @Override
    public void execute() {
        WorldHop.hopTo(327);

    }
}
