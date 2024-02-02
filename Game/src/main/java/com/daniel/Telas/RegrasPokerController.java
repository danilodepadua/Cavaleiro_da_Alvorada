package com.daniel.Telas;

import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.Telas.Utilidades.*;

public class RegrasPokerController implements Initializable {
    @FXML
    private Button btnProsseguir;
    @FXML
    private Button btnVoltar;
    @FXML
    private AnchorPane panePrincipal;

    @FXML
    void onClickContinuar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaPoker.fxml")).load());

    }
    @FXML
    void onClickVoltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCassino.fxml")).load());

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        definirBackground(panePrincipal, "/com.daniel.Images/Cartas/MesaTaverna.jpeg");
        contornarBotaoVoltar(btnVoltar);
        configurarBotoes(btnProsseguir);
    }
}
