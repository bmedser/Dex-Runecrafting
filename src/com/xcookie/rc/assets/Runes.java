package com.xcookie.rc.assets;

import com.runemate.game.api.hybrid.cache.sprites.Sprite;
import com.runemate.game.api.hybrid.entities.definitions.ItemDefinition;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;

public class Runes {

    //basic runes
    public static int airCount, bodyCount, earthCount, fireCount, mindCount, waterCount ;

    //other
    public static int astralCount,  bloodCount, chaosCount, cosmicCount, deathCount, lawCount, natureCount, soulCount;

    //mixed
    public static int smokeCount, steamCount, mudCount, dustCount, lavaCount, mistCount;

//    public static SpriteItem fire = new SpriteItem(554, 1);
//    public static SpriteItem water = new SpriteItem(555, 1);
//    public static SpriteItem air = new SpriteItem(556, 1);
//    public static SpriteItem earth = new SpriteItem(557, 1);
//    public static SpriteItem mind = new SpriteItem(558, 1);
//    public static SpriteItem body = new SpriteItem(559, 1);
//    public static SpriteItem death = new SpriteItem(560, 1);
//    public static SpriteItem nature = new SpriteItem(561, 1);
//    public static SpriteItem chaos = new SpriteItem(562, 1);
//    public static SpriteItem law = new SpriteItem(563, 1);
//    public static SpriteItem cosmic = new SpriteItem(564, 1);
//    public static SpriteItem blood = new SpriteItem(565, 1);
//    public static SpriteItem soul = new SpriteItem(566, 1);
    public final ItemDefinition essence = ItemDefinition.get(Items.pureEss.getId());

    public static ItemDefinition fire = ItemDefinition.get(554);
    public static ItemDefinition water = ItemDefinition.get(555);
    public static ItemDefinition air = ItemDefinition.get(556);
    public static ItemDefinition earth = ItemDefinition.get(557);
    public static ItemDefinition mind = ItemDefinition.get(558);
    public static ItemDefinition body = ItemDefinition.get(559);
    public static ItemDefinition death = ItemDefinition.get(560);
    public static ItemDefinition nature = ItemDefinition.get(561);
    public static ItemDefinition chaos = ItemDefinition.get(562);
    public static ItemDefinition law = ItemDefinition.get(563);
    public static ItemDefinition cosmic = ItemDefinition.get(564);
    public static ItemDefinition blood = ItemDefinition.get(565);
    public static ItemDefinition soul = ItemDefinition.get(566);

}
