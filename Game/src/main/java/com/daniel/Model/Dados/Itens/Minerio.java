package com.daniel.Model.Dados.Itens;

public abstract class Minerio extends Item{
    public Minerio(String imgPath, String nome, int quant, int preco, String desc) {
        super(imgPath, nome, quant, preco, desc);
    }
}