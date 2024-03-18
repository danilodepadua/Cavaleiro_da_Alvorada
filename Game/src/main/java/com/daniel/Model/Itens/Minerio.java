package com.daniel.Model.Itens;

import com.daniel.Model.Dados.Textos.TextoNode;

public abstract class Minerio extends Item{
    public Minerio(String imgPath, TextoNode nome, int quant, int preco, TextoNode desc) {
        super(imgPath, nome, quant, preco, desc);
    }
}
