package com.daniel.View;

import com.daniel.Controller.JogoFachada;
import com.daniel.Model.AudioPlayer;
import com.daniel.Model.Dados.Textos.TextosInterface;
import com.daniel.Model.Exceptions.SaveInexistenteException;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.View.Utilidades.*;


public class MainController implements Initializable {

    @FXML
    private AnchorPane Screen;
    @FXML
    private Text Txt_Titulo;

    @FXML
    private Button btnConfig;

    @FXML
    private Button btnNovoJogo;

    @FXML
    private Button btnSair;
    @FXML
    private VBox vbox;
    @FXML
    private Button btnCreditos;

    public static AudioPlayer audioPlayerInicial = new AudioPlayer();

    @FXML
    void Iniciar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaSaves.fxml")).load());
    }
    @FXML
    void Configurar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaConfiguracoes.fxml")).load());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        JogoFachada.getInstance().getAudioPlayer().PlayLoop("/com.daniel.audios/NovasMusicas/Eventos/MenuInical/Prologue_intro.mp3", "/com.daniel.audios/NovasMusicas/Eventos/MenuInical/Prologue_loop.mp3");
        definirBackground(Screen, "/com.daniel.Images/Fundos/Guerreiro.jpg");
        configurarBotoes(btnConfig);
        configurarBotoes(btnSair);
        configurarBotoes(btnNovoJogo);
        configurarBotoes(btnCreditos);
        identificarTextos(Screen);
        btnConfig.setText(TextosInterface.getConfig());
        btnNovoJogo.setText(TextosInterface.getNovoJogo());
        btnSair.setText(TextosInterface.getSair());
        btnCreditos.setText(TextosInterface.getCreditos());
        Txt_Titulo.setText(TextosInterface.getTitulo());
    }

    @FXML
    void Sair(ActionEvent event) {
        audioPlayerInicial.somMouseClick(btnSair, "/com.daniel.audios/musica_menu.wav");
        System.exit(0);
    }

    @FXML
    void OnActionCreditos(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCreditos.fxml")).load());

    }

}
