package com.daniel.Repositorios;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AnimationsAttack {
    protected Image[] Images;
    int Time = 50;
    public Timeline Play(ImageView View){
        System.out.println("Iniciou animação");
        Timeline timeline = new Timeline();
        for(int i = 0; i<Images.length; i++){
            final int j = i;
            KeyFrame key = new KeyFrame(Duration.millis(i*Time), event -> {System.out.println("Frame Passado: " + j); ;View.setImage(Images[j]);});
            timeline.getKeyFrames().add(key);
            System.out.println("Frame atual: " + j);
        }
        KeyFrame key = new KeyFrame(Duration.millis(Time * Images.length), event -> View.setImage(null));
        timeline.getKeyFrames().add(key);
        return timeline;
    }
}
