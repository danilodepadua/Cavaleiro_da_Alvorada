package com.daniel.View;

import com.daniel.Controller.JogoFachada;
import com.daniel.Model.AudioPlayer;
import com.daniel.Model.Dados.Textos.TextosIntroducao;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.daniel.View.Utilidades.contornarBotaoVoltar;

public class StorySceneController implements Initializable {


    private Timeline timeL;
    @FXML
    private AnchorPane Screen;



    Image[] Fundos = { new Image(Main.class.getResource("/com.daniel.Images/Fundos/FundosIntro/TerraDestruida.jpg").toString()),new Image(Main.class.getResource("/com.daniel.Images/Fundos/FundosIntro/BatalhaAntiga.jpg").toString()),new Image(Main.class.getResource("/com.daniel.Images/Fundos/FundosIntro/CidadeEmPaz.jpg").toString()),new Image(Main.class.getResource("/com.daniel.Images/Fundos/Guerreiro.jpg").toString()),new Image(Main.class.getResource("/com.daniel.Images/Fundos/Guerreiro.jpg").toString())};

    @FXML
    private Text Texto;
    @FXML
    private Button btnSkip;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        JogoFachada.getInstance().getAudioPlayer().PlayLoop("/com.daniel.audios/NovasMusicas/Eventos/main-theme04.mp3");

        timeL = adicionarCaracteresComAtraso();
        btnSkip.rotateProperty().set(180);
        btnSkip.setOnAction(this::skipDialog);
        contornarBotaoVoltar(btnSkip);
    }

    public void Mudar() throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCriacaoPersonagem.fxml")).load());
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
        String[] Dialogo = TextosIntroducao.getIntroducao();
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
                            JogoFachada.getInstance().getAudioPlayer().PlayEfeito("/com.daniel.audios/som_dialogo_storyscene.wav");


                        }
                );
                if(Dialogo[finalI].charAt(finalJ) == '.'){
                    Time+= 1000;
                } else if (Dialogo[finalI].charAt(finalJ) == ',') {
                    Time+= 200;
                }
                if(finalJ == Dialogo[finalI].length()-1) {
                    Time+=7000;
                    KeyFrame Frame = new KeyFrame(
                            Duration.millis(Time),
                            event -> {Texto.setText("");});
                    timeline.getKeyFrames().add(Frame);
                }
                Time+=100;
                timeline.getKeyFrames().add(keyFrame);
            }
        }
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(Time), event -> {
            try {
                Mudar();
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}