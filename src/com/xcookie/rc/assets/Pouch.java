package com.xcookie.rc.assets;

import com.runemate.game.api.hybrid.cache.sprites.Sprite;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.script.framework.listeners.InventoryListener;
import com.runemate.game.api.script.framework.listeners.events.ItemEvent;

import static com.runemate.game.api.hybrid.Environment.getLogger;

public enum Pouch implements InventoryListener {

    /**
     * spriteitem giant pouch
     *
     * if(giantpouch.interact("Fill"))
     * 	if event.getQuantityChange == 18
     * 		giant pouch.isfull =  true
     * 	else
     * 		giant pouch.isfull = false
     *
     */

    GIANT_POUCH("Giant pouch", false, 18, 5514),
    LARGE_POUCH("Large pouch", false, 12, 5512),
    MEDIUM_POUCH( "Medium pouch", false, 6, 5510),
    SMALL_POUCH("Small pouch", false, 3, 5509);

    Items items;
    Settings s = new Settings();

    Pouch(String name, boolean isFull, int capacity, int ids) {
        this.name = name;
        this.isFull = isFull;
        this.capacity = capacity;
        this.ids = ids;
    }



    //Variables
    private int index;
    private String name;
    private boolean isFull;
    private int ids;
    private String fill = "Fill";
    public static int avaliablePouches = 4;

    /**
     * How much essence can be held within the pouch
     */
    private int capacity;

    public void Pouch(Boolean isFull) {
        this.isFull = isFull;
//        pouch = pouch(pouch.getIndex(), pouch.getName(), isFull, pouch.getCapacity(), pouch.getIds());
    }

    public void fill(Pouch pouch) { //TODO: fill(GIANT_POUCH)
        SpriteItem tempPouch = new SpriteItem(pouch.getIds(), 1);
        tempPouch.interact(fill);
    }

    public void setPouchFilled(Pouch pouch) {
        boolean isFull = true;
        pouch.isFull = isFull;
        getLogger().severe(pouch.toString() + " is full");
//        this.pouch = pouch.isFull;
//        pouch(pouch.getIds(), pouch.getName(), pouch.isFull)
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

        if (capacity == event.getQuantityChange()) {
            getLogger().fine("Successfully filled " + getName());
            isFull = true;
        }

/*        //get pouched that was clicked, IF pouch removed its capacity it is full, otherwise return false, this way it keeps trying to fill up
        if(event.getItem().toString().equals("Pure essence") && event.getQuantityChange() == getCapacity()) {

        }*/

        if (event.getItem().getId() == Items.pureEss.getId()) {
            switch (event.getQuantityChange()) {
                case 3: // small
                    setPouchFilled(SMALL_POUCH);
                    break;
                case 6: //medium
                    setPouchFilled(MEDIUM_POUCH);
                    break;
                case 12: //large
                    setPouchFilled(LARGE_POUCH);
                    break;
                case 18: //giant
                    setPouchFilled(GIANT_POUCH);
                    break;
                default:
                    break;
            }
        }
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

