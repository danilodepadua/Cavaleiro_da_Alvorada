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
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("StoryScene.fxml")));
    }
    @FXML
    void Carregar(ActionEvent event){
        System.out.println("Carregando");
        Main.saveManager.Carregar();
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")));
    }
    @FXML
    void Configurar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaConfiguracoes.fxml")));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Screen.setBackground(new Background(new BackgroundImage(new Image(Main.class.getResource("/com.daniel.Images/Capa.jpg").toString()),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(
                        BackgroundSize.AUTO,
                        BackgroundSize.AUTO,
                        false,
                        false,
                        true,
                        true
                )))
        );
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