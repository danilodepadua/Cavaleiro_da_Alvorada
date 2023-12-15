package com.daniel.Repositorios;

import com.daniel.game.Main;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IceAnimation extends AnimationsAttack{
    public Timeline INICIAR(ImageView View) {
        System.out.println("Iniciou Preparação");
        super.Images = new Image[29];
        for(int i = 0; i<29; i++)
        {
            super.Images[i] = new Image(Main.class.getResource("/com.daniel.Images/Ice/Ice" +(i+1)+".png").toString());
        }
        System.out.println("Finalizou Preparação");
        System.out.println("Frames: " + super.Images.length);
        return Play(View);
    }
}
