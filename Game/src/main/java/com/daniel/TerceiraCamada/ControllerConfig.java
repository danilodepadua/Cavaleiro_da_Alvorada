package com.daniel.TerceiraCamada;

import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerConfig implements Initializable {

    @FXML
    private ChoiceBox<String> EscolhaResolucao;

    @FXML
    void Confirmar(ActionEvent event) {
        String[] tamanho = EscolhaResolucao.getValue().split("x");
        System.out.println("Largura = " + tamanho[0]);
        System.out.println("Altura = " + tamanho[1]);
        int largura = Integer.parseInt(tamanho[0]);
        int altura = Integer.parseInt(tamanho[1]);
        Main.MudarTamanhoTela(largura, altura);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EscolhaResolucao.getItems().addAll("1136x639","1200x675","1600x900");
        EscolhaResolucao.setValue("1136x639");
    }
}

