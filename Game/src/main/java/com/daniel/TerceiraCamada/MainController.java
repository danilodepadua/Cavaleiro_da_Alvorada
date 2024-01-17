package com.daniel.TerceiraCamada;

import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.TerceiraCamada.Utilidades.configurarBotoes;
import static com.daniel.TerceiraCamada.Utilidades.definirBackground;

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

    @FXML
    void Iniciar(ActionEvent event){
        System.out.println("Iniciou");
        Main.ChangeScene("StoryScene.fxml");
    }
    @FXML
    void Carregar(ActionEvent event){
        System.out.println("Carregando");
        Main.saveManager.Carregar();
        Main.ChangeScene("TelaCidade.fxml");
    }
    @FXML
    void Configurar(ActionEvent event) {
        Main.ChangeScene("TelaConfiguracoes.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        definirBackground(Screen, "/com.daniel.Images/Calabouso.jpg");
        configurarBotoes(btnCarregar);
        configurarBotoes(btnConfig);
        configurarBotoes(btnSair);
        configurarBotoes(btnNovoJogo);
    }

    @FXML
    void Sair(ActionEvent event) {
        System.exit(0);
    }
}