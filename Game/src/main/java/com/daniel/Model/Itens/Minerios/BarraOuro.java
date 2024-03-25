package com.daniel.Model.Itens.Minerios;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class BarraOuro extends Minerio {
    public BarraOuro(){
        super("/com.daniel.Images/Itens/Minerios/BarraOuro.png", new TextoNode("Barra de Ouro", "Gold bar"), 1, 12000, new TextoNode("Barra refinada de Ouro","Refined gold bar"));
    }

    public BarraOuro(int quant) {
        super("/com.daniel.Images/Itens/Minerios/BarraOuro.png", new TextoNode("Barra de Ouro", "Gold bar"), quant, 12000, new TextoNode("Barra refinada de Ouro","Refined gold bar"));
    }
}

