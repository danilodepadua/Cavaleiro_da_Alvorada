package com.daniel.Model.Itens.Armaduras;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Armadura;

public abstract class Peitoral extends Armadura {

    public Peitoral(String imgPath, TextoNode nome, int quant, int preco, TextoNode desc, int aumentoDanoFisico, int aumentoDanoMagico) {
        super(imgPath, nome, quant, preco, desc, aumentoDanoFisico, aumentoDanoMagico);
    }

}
