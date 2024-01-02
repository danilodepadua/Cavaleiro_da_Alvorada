package com.daniel.PrimeiraCamada.Itens;

import com.daniel.game.Main;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Item implements Serializable {
    protected String imagem;
    protected String nome;
    protected int quant = 1;
    protected int preço;
    protected String descricao;
    public Image getImage(){
        return new Image (Main.class.getResource(imagem).toString());
    }
    public String getNome() {
        return nome;
    }
    public int getQuant(){return quant;}
    public int getPreco() {
        return preço;
    }
    public String getDescricao() {
        return descricao;
    }
    public void MaisQuant(){
        this.quant++;
    }
    public void MenosQuant(){
        this.quant--;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
