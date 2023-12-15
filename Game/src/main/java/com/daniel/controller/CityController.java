package com.daniel.controller;

import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class CityController {

    @FXML
    private Button AnimTest;

    @FXML
    void Mudar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("AnimationsTest.fxml")));
    }

}