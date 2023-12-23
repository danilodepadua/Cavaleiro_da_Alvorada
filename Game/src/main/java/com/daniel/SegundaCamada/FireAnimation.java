package com.daniel.SegundaCamada;

import com.daniel.game.Main;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FireAnimation extends AnimationsAttack{
    public Timeline INICIAR(ImageView View) {
        super.Time = 20;
        System.out.println("Iniciou Preparação");
        super.Images = new Image[32];
        for(int i = 0; i<32; i++)
        {
            super.Images[i] = new Image(Main.class.getResource("/com.daniel.Images/Fire/Fire" +(i+1)+".png").toString());
        }
        System.out.println("Finalizou Preparação");
        System.out.println("Frames: " + super.Images.length);
        return Play(View);
    }
}
