package com.daniel.Model.Itens.Armaduras;

import com.daniel.Model.Itens.Armadura;

public abstract class Peitoral extends Armadura {

    public Peitoral(String imgPath, String nome, int quant, int preco, String desc, int aumentoDanoFisico, int aumentoDanoMagico) {
        super(imgPath, nome, quant, preco, desc, aumentoDanoFisico, aumentoDanoMagico);
    }

}
