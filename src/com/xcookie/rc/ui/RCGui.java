package com.xcookie.rc.ui;

import com.runemate.game.api.hybrid.util.Resources;
import com.xcookie.rc.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class RCGui extends GridPane implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setVisible(true);
    }
    // Input your Settings RCGui FXML file location here.
    // NOTE: DO NOT FORGET TO ADD IT TO MANIFEST AS A RESOURCE
    public RCGui(Main bot) {
        // Load the fxml file using RuneMate's resources class.
        FXMLLoader loader = new FXMLLoader();

        // Set the FXML load's root to this class
        // NOTE: By setting the root to (this) you must change your .fxml to reflect fx:root
        Future<InputStream> stream = bot.getPlatform().invokeLater(() -> Resources.getAsStream("com/xcookie/rc/ui/AltarUI.fxml"));

        // Set FlaxFXController as the class that will be handling our events
        loader.setController(new FXController(bot));


        loader.setRoot(this);

        try {
            loader.load(stream.get());
        } catch (IOException | InterruptedException | ExecutionException e) {
            System.err.println("Error loading RCGui");
            e.printStackTrace();
        }
    }
}
