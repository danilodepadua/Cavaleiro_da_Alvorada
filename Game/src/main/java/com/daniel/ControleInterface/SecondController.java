package com.daniel.ControleInterface;

import com.daniel.game.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {

    @FXML
    private ImageView BackGround;
    String[] Dialogo = {"Dialogo1", "Dialogo2", "Dialogo3"};
    Image[] Fundos = {new Image(Main.class.getResource("/com.daniel.Images/Predios.jpg").toString()), new Image(Main.class.getResource("/com.daniel.Images/Rua.jpg").toString()),new Image(Main.class.getResource("/com.daniel.Images/Trens.jpg").toString())};

    @FXML
    private Text Texto;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        adicionarCaracteresComAtraso();
    }

    public void Mudar(){
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("CharCreatorScene.fxml")));
    }

    private void adicionarCaracteresComAtraso() {
        Timeline timeline = new Timeline();
        double Time = 0;
        for (int i = 0; i < Dialogo.length; i++) {
            final int finalI = i;
            KeyFrame key = new KeyFrame(Duration.millis(Time),event -> BackGround.setImage(Fundos[finalI]));
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
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(Time + 100), event -> Mudar()));
        timeline.play();
    }
}