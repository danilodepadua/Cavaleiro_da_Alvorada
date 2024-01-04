package com.daniel.PrimeiraCamada;

import com.daniel.game.Main;
import javafx.scene.image.Image;

public abstract class Cidade {
    public String Fundo, FundoBatalha;
    public String Nome;

    public Image getFundo(){
        return new Image(Main.class.getResource(Fundo).toString());
    }
    public Image getFundoBatalha(){
        return new Image(Main.class.getResource(FundoBatalha).toString());
    }
}
