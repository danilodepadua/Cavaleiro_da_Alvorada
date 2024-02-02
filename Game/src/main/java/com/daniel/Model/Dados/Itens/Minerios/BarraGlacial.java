package com.daniel.Model.Dados.Itens.Minerios;

import com.daniel.Model.Dados.Itens.Minerio;

public class BarraGlacial extends Minerio {
    public BarraGlacial(){
        super("/com.daniel.Images/Itens/Minerios/BarraGlacial.png", "Barra Glacial", 1, 300, "Barra refinada de fragmentos de gelo");
    }

    public BarraGlacial(int quant) {
        super("/com.daniel.Images/Itens/Minerios/BarraGlacial.png", "Barra Glacial", quant, 300, "Barra refinada de fragmentos de gelo");
    }
}
