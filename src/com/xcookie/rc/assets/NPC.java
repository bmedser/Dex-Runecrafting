package com.xcookie.rc.assets;

import com.runemate.game.api.hybrid.entities.Entity;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.LocatableEntity;
import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.hybrid.entities.definitions.NpcDefinition;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.queries.LocatableEntityQueryBuilder;
import com.runemate.game.api.hybrid.queries.NpcQueryBuilder;
import com.runemate.game.api.hybrid.queries.results.LocatableEntityQueryResults;
import com.runemate.game.api.hybrid.region.Banks;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Npcs;

public class NPC {
    LocatableEntity locatableEntity;
    private static LocatableEntityQueryBuilder locatableEntityQueryBuilder;
//    public static LocatableEntity bank = Npcs.newQuery().actions("Bank").results();

    private static Settings settings = new Settings();
    public static Coordinate bankCoord = new Coordinate(3013, 5625, 0);
    private static String masterName = settings.getMaster();
    public NpcQueryBuilder master = Npcs.newQuery().names(masterName);

//    public static Npc Eniola = Npcs.newQuery().names("Eniola").ids(7417).on(bankCoord).actions("Bank", "Talk-to", "Collect").results().nearest();
    public static Npc Eniola = Npcs.newQuery().on(bankCoord).results().nearest();
//    public static GameObject Eniola = GameObjects.newQuery().names("Eniola").actions("Bank", "Talk-to", "Collect").on(bankCoord).results().nearest();

}
