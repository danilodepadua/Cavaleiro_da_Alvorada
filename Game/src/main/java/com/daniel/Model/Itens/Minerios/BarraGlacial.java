package com.daniel.Model.Itens.Minerios;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class BarraGlacial extends Minerio {
    public BarraGlacial(){
        super("/com.daniel.Images/Itens/Minerios/BarraGlacial.png", new TextoNode("Barra Glacial","Glacial bar"), 1, 300, new TextoNode("Barra refinada de fragmentos de gelo", "Refined bar of ice fragments"));
    }

    public BarraGlacial(int quant) {
        super("/com.daniel.Images/Itens/Minerios/BarraGlacial.png", new TextoNode("Barra Glacial","Glacial bar"), quant, 300, new TextoNode("Barra refinada de fragmentos de gelo", "Refined bar of ice fragments"));
    }
}
