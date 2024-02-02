package com.daniel.View;

import com.daniel.Model.Dados.AudioPlayer;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



import static com.daniel.View.Utilidades.configurarBotoes;
import static com.daniel.View.Utilidades.definirBackground;


public class MainController implements Initializable {

    @FXML
    private AnchorPane Screen;

    @FXML
    private Button btnCarregar;

    @FXML
    private Button btnConfig;

    @FXML
    private Button btnNovoJogo;

    @FXML
    private Button btnSair;

    public static AudioPlayer audioPlayerInicial = new AudioPlayer();

    @FXML
    void Iniciar(ActionEvent event) throws IOException {
        audioPlayerInicial.stop();
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("StoryScene.fxml")).load());

    }
    @FXML
    void Carregar(ActionEvent event) throws IOException {
        audioPlayerInicial.stop();
        Main.saveManager.Carregar();
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }
    @FXML
    void Configurar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaConfigInicial.fxml")).load());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        audioPlayerInicial.stop();
        audioPlayerInicial.play("/com.daniel.audios/musica_menu.wav", true);
        definirBackground(Screen, "/com.daniel.Images/Fundos/Guerreiro.jpg");
        configurarBotoes(btnCarregar);
        configurarBotoes(btnConfig);
        configurarBotoes(btnSair);
        configurarBotoes(btnNovoJogo);
        btnCarregar.setDisable(!Main.saveManager.SaveExistente());
    }

    @FXML
    void Sair(ActionEvent event) {
        audioPlayerInicial.somMouseClick(btnSair, "/com.daniel.audios/musica_menu.wav");
        System.exit(0);

    }



}
