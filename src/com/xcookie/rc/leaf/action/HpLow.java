package com.xcookie.rc.leaf.action;

import com.runemate.game.api.hybrid.entities.Actor;
import com.runemate.game.api.hybrid.local.hud.interfaces.Health;
import com.runemate.game.api.hybrid.queries.ActorQueryBuilder;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xcookie.rc.Main;
import com.xcookie.rc.assets.Locations;
import com.xcookie.rc.leaf.traverse.traverseEniola;

public class HpLow extends LeafTask {

    private Main bot;
    ActorQueryBuilder actor;

    @Override
    public void execute() {
        if (Health.getCurrentPercent() <= bot.getWarningHp()) {
            if ( (Locations.dangerZone.contains(Players.getLocal())) ) {                //if player in enemy locations
//                if();
                new traverseEniola();
            }
        }
    }
}

