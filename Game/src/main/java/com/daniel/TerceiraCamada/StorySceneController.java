package com.daniel.TerceiraCamada;

import com.daniel.game.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.stage.Window;

public class StorySceneController implements Initializable {

    @FXML
    private AnchorPane Screen;
    String[] Dialogo = {
            "Há eras, quando a passagem das coisas era incerta, um povo, não muito diferente do que agora chamamos de humanidade e do qual descendemos, compartilhava um antigo mundo com outro povo de natureza nefasta, inclinado a fazer nada além do mal. Hoje, os chamaríamos de demônios. Houve vários conflitos intermináveis entre os dois povos. Eventualmente, o lado maligno cedeu, e os vitoriosos forjaram um novo mundo a partir do antigo, que foi separado dos demônios. O tempo passou, e em um passado não muito distante, alcançamos um ponto de transição.",

            "Três selos ao longo do novo mundo, arquitetados para a preservação das estruturas fundamentais da nossa realidade, enfraqueceram, abrindo passagens que provocaram um abalo nas terras humanas. Isso permitiu a invasão demoníaca e nos colocou em rota de colisão iminente com o caos primordial.",

            "Você é o morador de uma pequena vila em um vasto continente, formado por vários reinos. Seu sonho sempre foi se tornar um cavaleiro e fazer do nome da sua pobre família algo grandioso e honroso. Em um dia nublado, notícias chegam à sua vila por viajantes passageiros, informando que um grande mal foi libertado na Montanha do Norte e está se espalhando pelas terras ao redor. Você vê isso como uma oportunidade de receber reconhecimento para o seu reino e parte em uma jornada para a capital, a fim de descobrir como pode ajudar e exigir reconhecimento caso vença o mal que foi libertado."
    };



    Image[] Fundos = { new Image(Main.class.getResource("/com.daniel.Images/Fundos/Fundo1.jpg").toString()),new Image(Main.class.getResource("/com.daniel.Images/Fundos/Fundo2.jpg").toString()),new Image(Main.class.getResource("/com.daniel.Images/Fundos/Fundo3.jpg").toString())};

    @FXML
    private Text Texto;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        adicionarCaracteresComAtraso();
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
    private void adicionarCaracteresComAtraso() {
        Timeline timeline = new Timeline();
        Texto.setStyle("-fx-font-family: 'Barlow Condensed SemiBold'; -fx-font-size: 35; -fx-fill: white");
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
                        event -> {Texto.setText(Texto.getText() + Dialogo[finalI].charAt(finalJ));}
                );
                if(finalJ == Dialogo[finalI].length()-1) {
                    Time+=1000;
                    KeyFrame Frame = new KeyFrame(
                            Duration.millis(Time),
                            event -> {Texto.setText("");});
                    timeline.getKeyFrames().add(Frame);
                }
                Time+=100;
                timeline.getKeyFrames().add(keyFrame);
            }
        }
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(Time + 100), event -> {
            try {
                Mudar();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
        timeline.play();
    }
}