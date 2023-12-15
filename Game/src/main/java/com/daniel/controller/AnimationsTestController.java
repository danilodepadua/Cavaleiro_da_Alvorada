package com.daniel.controller;

import com.daniel.Repositorios.FireAnimation;
import com.daniel.Repositorios.IceAnimation;
import com.daniel.Repositorios.SlashAnimation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AnimationsTestController implements Initializable {
    @FXML
    private ImageView Effect;
    @FXML
    private Button SlashButton;
    @FXML
    private Button FireButton;
    @FXML
    private Button IceButton;

    void slashAnim(){
        System.out.println("Ataque");
        new SlashAnimation().INICIAR(Effect).play();
    }
    void IceAnim(){
        new IceAnimation().INICIAR(Effect).play();
    }
    void FireAnim(){
        new FireAnimation().INICIAR(Effect).play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SlashButton.setOnAction(event -> slashAnim());
        FireButton.setOnAction(event -> FireAnim());
        IceButton.setOnAction(event -> IceAnim());
    }
}