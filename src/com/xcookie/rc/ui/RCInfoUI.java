package com.xcookie.rc.ui;

import com.runemate.game.api.hybrid.util.Resources;
import com.xcookie.rc.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class RCInfoUI  extends GridPane implements Initializable {

    Main bot;
    @FXML
    Label EssPH_L, EssCount_L, Runtime_L, CurrentTask_L;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setVisible(true);
    }

    public RCInfoUI(Main bot) {
        this.bot = bot;

        // Load the fxml file using RuneMate's resources class.
        FXMLLoader loader = new FXMLLoader();

        // Input your InfoUI FXML file location here.
        // NOTE: DO NOT FORGET TO ADD IT TO MANIFEST AS A RESOURCE
        Future<InputStream> stream = bot.getPlatform().invokeLater(() -> Resources.getAsStream("com/xcookie/ui/RCInfoUI.fxml"));


        // Set this class as root AND Controller for the Java FX RCGui
        loader.setController(this);

        // NOTE: By setting the root to (this) you must change your .fxml to reflect fx:root
        loader.setRoot(this);

        try {
            loader.load(stream.get());
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    // This method will update the text that is presented to the end user
    public void update() {
        try {
            Info i = bot.info;

            EssPH_L.setText("" + i.essPh);
            EssCount_L.setText("" + i.essCount);
            Runtime_L.setText("" + i.runTime);
            CurrentTask_L.setText(i.currentTask);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
