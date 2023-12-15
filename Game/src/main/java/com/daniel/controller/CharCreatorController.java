package com.daniel.controller;

import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CharCreatorController {

    Integer pontosDisp = 10;

    @FXML
    private ProgressBar BarraForca;

    @FXML
    private ProgressBar BarraVel;

    @FXML
    private ProgressBar BarraVida;

    @FXML
    private TextField Nome;

    @FXML
    private Text Pontos;

    @FXML
    void Criar(ActionEvent event) {
        System.out.println(Nome.getText());
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("InitialCity.fxml")));
    }

    @FXML
    void MaisForca(ActionEvent event) {
        if(pontosDisp>0) {
            pontosDisp--;
            Pontos.setText(pontosDisp.toString());
            BarraForca.setProgress(BarraForca.getProgress() + 0.05);
        }
    }

    @FXML
    void MaisVel(ActionEvent event) {
        if(pontosDisp>0) {
            pontosDisp--;
            Pontos.setText(pontosDisp.toString());
            BarraVel.setProgress(BarraVel.getProgress() + 0.05);
        }
    }

    @FXML
    void MaisVida(ActionEvent event) {
        if(pontosDisp>0){
        pontosDisp--;
        Pontos.setText(pontosDisp.toString());
        BarraVida.setProgress(BarraVida.getProgress() + 0.05);
        }
    }

    @FXML
    void MenosForca(ActionEvent event) {
        if(BarraForca.getProgress() > 0.25) {
            pontosDisp++;
            Pontos.setText(pontosDisp.toString());
            BarraForca.setProgress(BarraForca.getProgress() - 0.05);
        }
    }

    @FXML
    void MenosVel(ActionEvent event) {
        if(BarraVel.getProgress() > 0.25) {
            pontosDisp++;
            Pontos.setText(pontosDisp.toString());
            BarraVel.setProgress(BarraVel.getProgress() - 0.05);
        }
    }

    @FXML
    void MenosVida(ActionEvent event) {
        if(BarraVida.getProgress() > 0.25) {
            pontosDisp++;
            Pontos.setText(pontosDisp.toString());
            BarraVida.setProgress(BarraVida.getProgress() - 0.05);
        }
    }
}