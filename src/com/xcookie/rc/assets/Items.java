package com.xcookie.rc.assets;

import com.runemate.game.api.hybrid.cache.sprites.Sprite;
import com.runemate.game.api.hybrid.entities.Item;
import com.runemate.game.api.hybrid.entities.definitions.ItemDefinition;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import org.apache.commons.lang3.ArrayUtils;

public class Items {

    Item item;



    public String altarRunes[] = {"Air rune", "Mind rune", "Water rune", "Earth rune", "Fire rune",
                                "Body rune", "Cosmic rune", "Chaos rune", "Astral rune", "Nature rune",
                                "Law rune", "Death rune", "Blood rune", "Soul rune", "Wrath rune"};



    //Essence
    public static SpriteItem essence = new SpriteItem(1436, 1);
    public static SpriteItem pureEss = new SpriteItem(	7936, 1);
    public static SpriteItem essences[] = {essence,pureEss};

    //Pouches
    public static SpriteItem giantPouch = new SpriteItem(5514, 1);
    public static SpriteItem largePouch = new SpriteItem(5512, 1);
    public static SpriteItem mediumPouch = new SpriteItem(5510, 1);
    public static SpriteItem smallPouch = new SpriteItem(5509, 1);

    //Broken pouches (need to be repaired)
    public static SpriteItem brokenGiantPouch = new SpriteItem(5515, 1);
    public static SpriteItem brokenLargePouch = new SpriteItem(5513, 1);
    public static SpriteItem brokenMediumPouch = new SpriteItem(5511, 1);
    /**small never break*/

    //Other
    public static SpriteItem runePouch = new SpriteItem(12791, 1);
    public static SpriteItem emptyRunePouch = new SpriteItem(15092, 1);

    //Arrays
    public static int pouchIds[] = {giantPouch.getId(), largePouch.getId(), mediumPouch.getId(), smallPouch.getId()};
    public static SpriteItem pouches[] = {giantPouch, largePouch, mediumPouch, smallPouch};
    public static int brokenPouchIds[] = {brokenGiantPouch.getId(), brokenLargePouch.getId(), brokenMediumPouch.getId()};
    public static SpriteItem brokenPouch[] = {brokenGiantPouch, brokenLargePouch, brokenMediumPouch};

    public static int[] getIds(SpriteItem... spriteItems) {
        for (SpriteItem s : spriteItems) {
            return new int[s.getId()];
        }
        return null;
    }


    public static int runePouchIds[] = {runePouch.getId(), emptyRunePouch.getId()};

    public static int[] importantItems = ArrayUtils.addAll(pouchIds, runePouchIds);
//    public static int[] requiredItems = ArrayUtils.addAll(importantItems, pureEss.getId());
    public static int requiredItems = (pureEss.getId());

    public static int withdrawItems[] = {pureEss.getId()};



}
