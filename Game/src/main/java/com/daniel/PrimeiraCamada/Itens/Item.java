package com.daniel.PrimeiraCamada.Itens;

import javafx.scene.image.Image;

public class Item {
    private String nome;
    private Image imagem;
    public Item(String nome, Image imagem) {
        this.nome = nome;
        this.imagem = imagem;
    }
    public Image getImage(){
        return imagem;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
