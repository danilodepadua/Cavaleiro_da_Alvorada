package com.daniel.SegundaCamada;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class AnimationsAttack {
    Timeline Play(ImageView View, int tempo, Image[] Images){
        System.out.println("Iniciou animação");
        Timeline timeline = new Timeline();
        for(int i = 0; i<Images.length; i++){
            final int j = i;
            KeyFrame key = new KeyFrame(Duration.millis(i*tempo), event -> {System.out.println("Frame Passado: " + j); ;View.setImage(Images[j]);});
            timeline.getKeyFrames().add(key);
            System.out.println("Frame atual: " + j);
        }
        KeyFrame key = new KeyFrame(Duration.millis(tempo * Images.length), event -> View.setImage(null));
        timeline.getKeyFrames().add(key);
        return timeline;
    }
    abstract Timeline INICIAR(ImageView View);
}
