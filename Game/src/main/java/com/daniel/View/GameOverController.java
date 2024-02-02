package com.daniel.View;

import com.daniel.Model.Dados.AudioPlayer;
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

import static com.daniel.View.Utilidades.configurarBotoes;
import static com.daniel.View.Utilidades.definirBackground;

public class GameOverController implements Initializable {
    private AudioPlayer audioPlayer = new AudioPlayer();

    @FXML
    private Button btnCarregar;

    @FXML
    private Button btnSair;

    @FXML
    private AnchorPane panePrincipal;
    @FXML
    void onClickCarregar(ActionEvent event) throws IOException {
        Main.saveManager.Carregar();
        audioPlayer.stop();
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }

    @FXML
    void onClickSair(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        audioPlayer.play("/com.daniel.audios/som_derrota.wav", false);
        definirBackground(panePrincipal, "/com.daniel.Images/Fundos/Fundo.png");
        configurarBotoes(btnCarregar);
        configurarBotoes(btnSair);
    }
}
