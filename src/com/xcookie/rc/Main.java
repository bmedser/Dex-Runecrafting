package com.xcookie.rc;

import com.runemate.game.api.client.embeddable.EmbeddableUI;
import com.runemate.game.api.hybrid.cache.sprites.Sprite;
import com.runemate.game.api.hybrid.local.Rune;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.hybrid.util.StopWatch;
import com.runemate.game.api.hybrid.util.calculations.CommonMath;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.listeners.InventoryListener;
import com.runemate.game.api.script.framework.listeners.events.ItemEvent;
import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xcookie.rc.assets.Items;
import com.xcookie.rc.branch.Root;
import com.xcookie.rc.ui.RCGui;
import com.xcookie.rc.ui.Info;
import com.xcookie.rc.ui.RCInfoUI;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;

import java.util.concurrent.TimeUnit;

public class Main extends TreeBot implements EmbeddableUI, InventoryListener {

    public StopWatch stopWatch = new StopWatch();

    private RCGui configUI;
    private int essCount;
    public Info info;
    private RCInfoUI infoUI;
    private SimpleObjectProperty<Node> botInterfaceProperty;

    private Root root = new Root();
    public Boolean guiWait;

    public String getCurrentTaskString() {
        return currentTaskString;
    }

    public void setCurrentTaskString(String currentTaskString) {
        this.currentTaskString = currentTaskString;
    }

    public String currentTaskString;


//    public TraversalLocation traversalLocation = TraversalLocation.flaxArea;

    /** TODO
     *
     *  Enable protection from magic/range prayers when traversing to altar
     *
     *  If hp below getCurrentPercent <= 75, find food in bank (array spriteitem?) and withdraw, eat
     *
     *  If run below 50 and non stamina, withdraw stamina pot and drink
     *
     *  Pouch fill methods
     *
     *  Make sure game has gotten past news interface before starting bot
     *
     *  inventorylistener counter to relevant runes, count them in gp worth and display in gui?
     *
     *  Add status strings to each methods for gui
     *
     */
    public Main(){
        guiWait = true;
        essCount = 0;
        setEmbeddableUI(this);
    }

    @Override
    public TreeTask createRootTask() {
        Execution.delay(2000); //todo: length between each tree loop
        return root;
    }

    @Override
    public void onStart(String... args) {
        getEventDispatcher().addListener(this);
        stopWatch.start();
        currentTaskString = "Started bot";
        setLoopDelay(300, 600);
        getEventDispatcher().addListener(this);
    }

    @Override
    public void onItemRemoved(ItemEvent event) {
        System.out.println("Item Removed: " + event.getItem() + " (" + event.getQuantityChange() + ")");
    }

    @Override
    public void onItemAdded(ItemEvent event) {

        System.out.println("Item Added: " + event.getItem() + " (" + event.getQuantityChange() + ")");

        if(event.getItem() == Items.pureEss) {
            essCount++;
        }

        if (event.toString().equals(Rune.AIR.getName())) {
            getLogger().severe("air rune in inventory@!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
    }

    @Override
    public ObjectProperty<? extends Node> botInterfaceProperty() {
        if (botInterfaceProperty == null) {
            // Initializing configUI in this manor is known as Lazy Instantiation
            botInterfaceProperty = new SimpleObjectProperty<>(configUI = new RCGui(this));
            infoUI = new RCInfoUI(this);
        }
        return botInterfaceProperty;
    }

    // When called, switch the botInterfaceProperty to reflect the InfoUI
    public void setToInfoProperty() {
        botInterfaceProperty.set(infoUI);
    }

    public void updateInfo() {
        try {
            // Assign all values to a new instance of the Info class
            info = new Info(
                    (int) CommonMath.rate(TimeUnit.HOURS, stopWatch.getRuntime(), essCount),  //   -   -   -   -   -   -   -   // Flax per hour
                    essCount,                //    -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   // Essence Picked
                    stopWatch.getRuntimeAsString(),                 //  -   -   -   -   -   -   -   -   -   -   -   -   -   -   // Total Runtime
                    currentTaskString);       //    -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   // Current Task

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Be sure to run infoUI.update() through runLater.
        // This will run infoUI.update() on the dedicated JavaFX thread which is the only thread allowed to update anything related to JavaFX rendering
        Platform.runLater(() -> infoUI.update());
    }
}
