package com.daniel.controller;

import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Objects;

public class MainController {

    @FXML
    void Iniciar(ActionEvent event) throws IOException {
        System.out.println("Iniciou");
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("StoryScene.fxml")));
    }
}