package com.daniel.PrimeiraCamada;

import com.daniel.game.Main;
import javafx.scene.image.Image;

public abstract class Cidade {
    protected String Fundo, FundoBatalha;
    protected String Nome;
    protected Inimigo[] inimigos;
    public Cidade(String nome, String fundo, String fundoB){
        this.Fundo = fundo;
        this.FundoBatalha = fundoB;
        this.Nome = nome;
    }

    public Image getFundo(){
        return new Image(Main.class.getResource(Fundo).toString());
    }
    public Image getFundoBatalha(){
        return new Image(Main.class.getResource(FundoBatalha).toString());
    }
    public Inimigo[] getInimigos(){return inimigos;}
}
