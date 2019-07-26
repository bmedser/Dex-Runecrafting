package com.xcookie.rc.assets;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.Npc;
import com.runemate.game.api.hybrid.entities.definitions.GameObjectDefinition;
import com.runemate.game.api.hybrid.entities.definitions.NpcDefinition;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.queries.GameObjectQueryBuilder;
import com.runemate.game.api.hybrid.region.GameObjects;

public class Objects {

    Locations locations = new Locations();

//    public GameObjectQueryBuilder PrayerAltar = GameObjects.newQuery().names("Chaos altar").on(new Coordinate(2527, 3303, 0)); //411
//    public GameObjectQueryBuilder ZMIAltar = GameObjects.newQuery().names("Runecrafting altar").within(locations.ZMIRCAltar); //29631
//    public GameObjectQueryBuilder Ladder = GameObjects.newQuery().names("Climb down").on(locations.ZMIWorldLadder.getCoordinates()); //29635

    public GameObject runecraftingAltar = GameObjects.newQuery().ids(29631).results().first();
//    public GameObject ladderEntry = GameObjects.newQuery().ids(29635).on(locations.ZMIWorldLadder.getCoordinates()).results().first();
//    public GameObject ladderEntry = GameObjects.newQuery().ids(29635).results().first();
    public GameObject ladderEntry = GameObjects.newQuery().on(Locations.ZMIWorldLadder).results().nearest(); //temporary for glitch...
//    public GameObject ladderExit = GameObjects.newQuery().names("Ladder").on(locations.ZMIWorldLadder.getCoordinates()).results().first();
    public GameObject chaosAltar = GameObjects.newQuery().ids(411).on().results().first();
//    public GameObject bankEniola = GameObjects.newQuery().ids(7417).results().first();
//    public GameObject bankEniola = GameObjects.newQuery().ids(7417).within(Locations.ZMIBank).results().first();
}
