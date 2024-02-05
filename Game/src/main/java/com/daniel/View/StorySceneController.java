package com.daniel.View;

import com.daniel.Model.Dados.AudioPlayer;
import com.daniel.Model.Dados.ConfiguracoesUsuario;
import com.daniel.game.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.View.Utilidades.contornarBotaoVoltar;

public class StorySceneController implements Initializable {


    private Timeline timeL;
    @FXML
    private AnchorPane Screen;
    String[] Dialogo = {
            "Há eras, em um mundo antigo, um povo enfrentou demônios em conflitos intermináveis. Vitoriosos, criaram um novo mundo separado dos demônios. Com o tempo, chegamos a um ponto de transição.",

            "Três selos enfraqueceram, abrindo passagens que permitiram a invasão demoníaca. Estamos em rota de colisão com o caos primordial.",

            "Você, morador de uma vila, sonha em se tornar cavaleiro. Notícias de um grande mal na Montanha do Norte chegam, e você parte em uma jornada para a capital em busca de reconhecimento e para derrotar o mal liberado."
    };



    Image[] Fundos = { new Image(Main.class.getResource("/com.daniel.Images/Fundos/Fundo1.jpg").toString()),new Image(Main.class.getResource("/com.daniel.Images/Fundos/Fundo2.jpg").toString()),new Image(Main.class.getResource("/com.daniel.Images/Fundos/Fundo3.jpg").toString())};

    @FXML
    private Text Texto;
    @FXML
    private Button btnSkip;
    private AudioPlayer audioPlayer = new AudioPlayer();
    private AudioPlayer clickSoundPlayer = new AudioPlayer();
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        audioPlayer.play("/com.daniel.audios/msc_historia.wav",false);

        timeL = adicionarCaracteresComAtraso();
        btnSkip.rotateProperty().set(180);
        btnSkip.setOnAction(this::skipDialog);
        contornarBotaoVoltar(btnSkip);
    }

    public void Mudar() throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("CharCreatorScene.fxml")).load());
    }

    public void MudarBackGround(Image imagem){
        Screen.setBackground(new Background(new BackgroundImage(imagem,
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
                        )
                )
                )
        );
    }
    private Timeline adicionarCaracteresComAtraso() {
        Timeline timeline = new Timeline();
        Texto.setStyle("-fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 35; -fx-fill: black");
        Texto.setWrappingWidth(1100);
        double Time = 50;
        for (int i = 0; i < Dialogo.length; i++) {
            final int finalI = i;
            KeyFrame key = new KeyFrame(Duration.millis(Time),event -> MudarBackGround(Fundos[finalI]));
            timeline.getKeyFrames().add(key);
            for (int j = 0; j < Dialogo[i].length(); j++) {
                final int finalJ = j;
                KeyFrame keyFrame = new KeyFrame(
                        Duration.millis(Time),
                        event -> {

                            Texto.setText(Texto.getText() + Dialogo[finalI].charAt(finalJ));
                            clickSoundPlayer.play("/com.daniel.audios/som_dialogo_storyscene.wav", false);


                        }
                );
                if(finalJ == Dialogo[finalI].length()-1) {
                    Time+=1000;
                    KeyFrame Frame = new KeyFrame(
                            Duration.millis(Time),
                            event -> {Texto.setText("");});
                    timeline.getKeyFrames().add(Frame);
                }
                System.out.println(ConfiguracoesUsuario.obterVelelocidadeTextoHistoriaPadrao());
                Time+=100/ConfiguracoesUsuario.obterVelelocidadeTextoHistoriaPadrao();
                timeline.getKeyFrames().add(keyFrame);
            }
        }
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(Time + 100), event -> {
            try {
                Mudar();
                audioPlayer.stop();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
        timeline.play();
        return timeline;
    }
    @FXML
    void skipDialog(ActionEvent event) {
        try {
            timeL.stop();
            Mudar();
            audioPlayer.stop();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}