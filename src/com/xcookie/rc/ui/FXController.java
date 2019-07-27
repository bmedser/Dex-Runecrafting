package com.xcookie.rc.ui;

import com.xcookie.rc.Main;
import com.xcookie.rc.assets.Runecrafting;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class FXController implements Initializable {

    private Main bot;
    public String masterRSN;
    public boolean isRunning = false;

    public FXController(Main bot) {
        this.bot = bot;
    }

    @FXML
    private ComboBox Location_ComboBox;

    @FXML
    private Button Start_BT;

    @FXML
    private TextField masterNameTextBox;

    @FXML
    private CheckBox IsRunningCheckBox;

    @FXML
    void IsRunningCheckBoxEvent(ActionEvent event) {
        System.out.println("Checkbox event");
        isRunning = IsRunningCheckBox.isSelected();
    }

    @FXML
    void masterNameTextBoxEvent(ActionEvent event) {
        System.out.println("Textbox event");
        masterRSN = masterNameTextBox.getText();
    }

    @FXML
    void StartButtonEvent(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Add Locations to the combo box
        Location_ComboBox.getItems().addAll(Runecrafting.values());

        // If the Start Button is pressed, handle that even in the getStart_BTAction method
        Start_BT.setOnAction(getStart_BTAction());

        // Set the event for Location_ComboBox
        Location_ComboBox.setOnAction(getLocation_ComboBoxEvent());
    }

    public EventHandler<ActionEvent> getStart_BTAction() {
        return event -> {
            try {
                // Initialize all variables in your bot
                bot.guiWait = false;
/*
                switch (Location_ComboBox.getSelectionModel().getSelectedIndex()) {
                    case : //ZMI

                }

                switch (Location_ComboBox.getSelectionModel().getSelectedItem()) {
                    case "Taverly":
                        bot.flaxArea = bot.TAV_FLAX_AREA;
                        bot.bankArea = bot.TAV_BANK_AREA;
                        break;
                    case "Seers Village":
                        bot.flaxArea = bot.SEER_FLAX_AREA;
                        bot.bankArea = bot.SEER_BANK_AREA;
                }*/

                // Set the EmbeddableUI property to reflect your Info RCGui
                Platform.runLater(() -> bot.setToInfoProperty());

            } catch (Exception e) {
                e.printStackTrace();
            }

        };
    }

    public EventHandler<ActionEvent> getLocation_ComboBoxEvent() {
        return event -> {
            // If a value is assigned to the Combo Box, enable tot he Start Button.
            if (Location_ComboBox.getSelectionModel().getSelectedItem() != null)
                Start_BT.setDisable(false);
            else
                Start_BT.setDisable(true);
        };
    }
}

