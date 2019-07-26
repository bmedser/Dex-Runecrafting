package com.xcookie.rc.assets;

import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.local.Skills;
import com.runemate.game.api.hybrid.local.SpellBook;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.osrs.local.RunePouch;
import com.runemate.game.api.osrs.local.hud.interfaces.Magic;

import java.util.Arrays;

public class Player {

    private SpellBook spellBook;
    private Settings settings;

    private String username = "";
    private int currentEssence;
    private int totalEssence;
    private boolean brokenPouches = false;
    private int currency; //runes used on banker

    public Player() {
        settings = new Settings();
        username = Players.getLocal().getName();
    }

    public String getRunecraftingTask(int index) {
        return Runecrafting.values()[index].toString();
    }

    private boolean canTeleport() { //TODO: add required runes
        if(Skill.MAGIC.getCurrentLevel() >= 71 && settings.isLunars() /*&& Inventory.has RUNES*/) {
            return true;
        }
        return false;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public boolean isBrokenPouches() {
        return brokenPouches;
    }

    public void setBrokenPouches(boolean brokenPouches) {
        this.brokenPouches = brokenPouches;
    }

    public int getCurrentEssence() {
        return currentEssence;
    }

    public void setCurrentEssence(int essCount) {
        this.currentEssence = currentEssence;
    }

    public int getTotalEssence() {
        return totalEssence;
    }

    public void addTotalEssence(int totalEssence) { //just add the current essCount to this method to tally it up
        this.totalEssence += totalEssence;
    }

    @Override
    public String toString() {
        return "Player - " + username + " { \n" +
                "Giant pouch = " + String.valueOf(hasPouch[0]) + "\n" +
                "Large pouch = " + String.valueOf(hasPouch[1]) + "\n" +
                "Medium pouch = " + String.valueOf(hasPouch[2]) + "\n" +
                "Small pouch = " + String.valueOf(hasPouch[3]) + "\n" +
                "Current essence = " + getCurrentEssence() + "\n" +
                "Total essence traded = " + getTotalEssence() + "\n" +
                "Currency = " + getCurrency() + "\n" +
                '}';
    }

    public boolean hasGiantPouch(){
        return hasPouch[0];
    }
    public boolean hasLargePouch(){
        return hasPouch[1];
    }
    public boolean hasMediumPouch(){
        return hasPouch[2];
    }
    public boolean hasSmallPouch(){
        return hasPouch[3];
    }

    public boolean[] hasPouch = {
            false,  // Giant pouch
            false,  // Large pouch
            false,  // Medium pouch
            false   // Small pouch
    };


    public String getUsername() {
        return username;
    }

    public boolean[] getHasPouch() {
        return hasPouch;
    }

    public void setHasPouch(boolean[] hasPouch) {
        this.hasPouch = hasPouch;
    }
}
