package com.xcookie.rc;

import com.runemate.game.api.client.embeddable.EmbeddableUI;
import com.runemate.game.api.hybrid.RuneScape;
import com.runemate.game.api.hybrid.entities.definitions.ItemDefinition;
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
import com.xcookie.rc.assets.Runecrafting;
import com.xcookie.rc.assets.Runes;
import com.xcookie.rc.ui.RCGui;
import com.xcookie.rc.ui.Info;
import com.xcookie.rc.ui.RCInfoUI;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;

import java.util.concurrent.TimeUnit;

import static com.xcookie.rc.assets.Runes.*;

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
//        updateInfo();
//        Execution.delay(2000); //todo: length between each tree loop
        return root;
    }

    @Override
    public void onStart(String... args) {
/*        while(!RuneScape.isLoggedIn()) { //TODO will never run
            Execution.delay(100);
        }*/
        getEventDispatcher().addListener(this);
        stopWatch.start();
        currentTaskString = "Started bot";
//        setLoopDelay(300, 600);
    }

    @Override
    public void onItemRemoved(ItemEvent event) {
//        System.out.println("Item Removed: " + event.getItem() + " (" + event.getQuantityChange() + ")");
    }

    @Override
    public void onItemAdded(ItemEvent event) {
//        System.out.println("Item Added: " + event.getItem() + " (" + event.getQuantityChange() + ")");


        switch(event.getItem().getId()) {
            case 7936:
                essCount += event.getQuantityChange();
                break;
            case 554:
                fireCount += event.getQuantityChange();
                break;
            case 555:
                waterCount += event.getQuantityChange();
                break;
            case 556:
                airCount += event.getQuantityChange();
                break;
            case 557:
                earthCount += event.getQuantityChange();
                break;
            case 558:
                mindCount += event.getQuantityChange();
                break;
            case 559:
                bodyCount += event.getQuantityChange();
                break;
            case 560:
                deathCount += event.getQuantityChange();
                break;
            case 561:
                getLogger().debug("Nature runes: " + natureCount);
                natureCount += event.getQuantityChange();
                break;
            case 562:
                chaosCount += event.getQuantityChange();
                break;
            case 563:
                lawCount += event.getQuantityChange();
                break;
            case 564:
                cosmicCount += event.getQuantityChange();
                break;
            case 565:
                bloodCount += event.getQuantityChange();
                break;
            case 566:
                soulCount += event.getQuantityChange();
                break;

            default:
                getLogger().debug("Got item: " + event.getItem().toString());
                break;
        }


/*        if(essence.getId() == event.getItem().getId()) {
            getLogger().warn("Essence used: " + essCount);
            essCount = essCount + event.getQuantityChange();
        }

        if(air.getId() == event.getItem().getId()) {
            airCount = airCount + event.getQuantityChange();
        }
        if(body.getId() == event.getItem().getId()) {
            bodyCount = bodyCount + event.getQuantityChange();
        }
        if(earth.getId() == event.getItem().getId()) {
            earthCount = earthCount + event.getQuantityChange();
        }
        if(fire.getId() == event.getItem().getId()) {
            getLogger().warn("Fire : " + fireCount);
            fireCount = fireCount + event.getQuantityChange();
        }
        if(water.getId() == event.getItem().getId()) {
            getLogger().warn("Fire : " + fireCount);
            fireCount = fireCount + event.getQuantityChange();
        }*/

    }

    @Override
    public ObjectProperty<? extends Node> botInterfaceProperty() {
        if (botInterfaceProperty == null) {
            // Initializing configUI in this manor is known as Lazy Instantiation
//            botInterfaceProperty = new SimpleObjectProperty<>(configUI = new RCGui(this)); //todo
//            botInterfaceProperty = new SimpleObjectProperty<>(infoUI = new RCInfoUI(this)); //todo
//            infoUI = new RCInfoUI(this);
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


        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // Be sure to run infoUI.update() through runLater.
        // This will run infoUI.update() on the dedicated JavaFX thread which is the only thread allowed to update anything related to JavaFX rendering
//        Platform.runLater(() -> infoUI.update());
    }
}
