package com.daniel.Model.Itens;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.game.Main;
import javafx.scene.image.Image;

import java.io.Serializable;

public abstract class Item implements Serializable {
    protected String imagem;
    protected TextoNode nome;
    protected int quant = 1;
    protected int preco;
    protected TextoNode descricao;

    public Item(String imgPath, TextoNode nome, int quant, int preco, TextoNode desc){
        this.imagem = imgPath;
        this.descricao = desc;
        this.quant = quant;
        this.nome = nome;
        this.preco = preco;
    }
    public Image getImage(){
        return new Image (Main.class.getResource(imagem).toString());
    }
    public String getNome() {
        return nome.getTexto();
    }
    public int getQuant(){return quant;}
    public int getPreco() {
        return preco;
    }
    public String getDescricao() {
        return descricao.getTexto();
    }
    public void MaisQuant(){
        this.quant++;
    }
    public void MaisQuant(int i){this.quant+= i;}
    public void MenosQuant(){
        this.quant--;
    }
}
