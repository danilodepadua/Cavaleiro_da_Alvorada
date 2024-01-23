package com.daniel.TerceiraCamada;

import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

import javax.sound.sampled.*;
import java.io.IOException;
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
    private Clip clip;

    @FXML
    void Iniciar(ActionEvent event) throws IOException {
        pararMusica();
        System.out.println("Iniciou");
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("StoryScene.fxml")).load());

    }
    @FXML
    void Carregar(ActionEvent event) throws IOException {
        pararMusica();
        System.out.println("Carregando");
        Main.saveManager.Carregar();
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }
    @FXML
    void Configurar(ActionEvent event) throws IOException {
        pararMusica();
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaConfiguracoes.fxml")).load());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iniciarMusica("/com.daniel.audios/musica_menu.wav");
        definirBackground(Screen, "/com.daniel.Images/Fundos/Calabouso.jpg");
        configurarBotoes(btnCarregar);
        configurarBotoes(btnConfig);
        configurarBotoes(btnSair);
        configurarBotoes(btnNovoJogo);




    }

    @FXML
    void Sair(ActionEvent event) {
        System.exit(0);

    }

    private void iniciarMusica(String caminhoMusica) {
        try {
            URL resourceUrl = getClass().getResource(caminhoMusica);
            // debug
            if (resourceUrl == null) {
                System.err.println("arquivo de áudio não encontrado: ");
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(resourceUrl);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            clip.loop(Clip.LOOP_CONTINUOUSLY);

            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void pararMusica() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }


}
