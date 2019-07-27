package com.xcookie.rc.assets;

import com.runemate.game.api.hybrid.cache.sprites.Sprite;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.script.framework.listeners.InventoryListener;
import com.runemate.game.api.script.framework.listeners.events.ItemEvent;

public enum Pouch implements InventoryListener {

    GIANT_POUCH(0, "Giant pouch", false, 18, 5514),
    LARGE_POUCH(1, "Large pouch", false, 12, 5512),
    MEDIUM_POUCH(2, "Medium pouch", false, 6,5510),
    SMALL_POUCH(3, "Small pouch", false, 3,5509);

    Items items;
    Settings s = new Settings();

    Pouch(int index, String name, boolean isFull, int capacity, int ids) {
        this.index = index;
        this.name = name;
        this.isFull = isFull;
        this.capacity = capacity;
        this.ids = ids;
    }

    //Variables
    private final int index;
    private final String name;
    private boolean isFull;
    private final int ids;
    private int id;
    private final String fill = "Fill";

    /**How much essence can be held within the pouch*/
    private final int capacity;

    public void fill(Pouch pouch) { //TODO: fill(GIANT_POUCH)
        SpriteItem tempPouch = new SpriteItem(pouch.getIds(), 1);
        tempPouch.interact(fill);
    }


    @Override
    public String toString() {
        return "Pouch{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public void onItemAdded(ItemEvent event) {

    }

    @Override
    public void onItemRemoved(ItemEvent event) {
        if(event.getItem() == items.pureEss) {

        }
        //get pouched that was clicked, IF pouch removed its capacity it is full, otherwise return false, this way it keeps trying to fill up
        if(event.getItem().toString().equals("Pure essence") && event.getQuantityChange() == getCapacity()) {

        }

        switch(event.getQuantityChange()) {
            case 3:

        }

    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public boolean isFull() {
        return isFull;
    }

    public int getCapacity() {
        return capacity;
    }
    public int getIds() {
        return ids;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}

