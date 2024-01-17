package com.daniel.TerceiraCamada;

import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.TerceiraCamada.Utilidades.configurarBotoes;
import static com.daniel.TerceiraCamada.Utilidades.definirBackground;

public class ControllerGameOver implements Initializable {
    @FXML
    private Button btnCarregar;

    @FXML
    private Button btnSair;

    @FXML
    private AnchorPane panePrincipal;
    @FXML
    void onClickCarregar(ActionEvent event) {
        Main.saveManager.Carregar();
        Main.ChangeScene("TelaCidade.fxml");
    }

    @FXML
    void onClickSair(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        definirBackground(panePrincipal, "/com.daniel.Images/Fundo.png");
        configurarBotoes(btnCarregar);
        configurarBotoes(btnSair);
    }
}
