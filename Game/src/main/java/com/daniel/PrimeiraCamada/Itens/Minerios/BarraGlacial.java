package com.daniel.PrimeiraCamada.Itens.Minerios;

import com.daniel.PrimeiraCamada.Itens.Item;

public class BarraGlacial extends Item {
    public BarraGlacial(){
        super("/com.daniel.Images/Itens/Minerios/BarraGlacial.png", "Barra Glacial", 1, 300, "Barra refinada de fragmentos de gelo");
    }

    public BarraGlacial(int quant) {
        super("/com.daniel.Images/Itens/Minerios/BarraGlacial.png", "Barra Glacial", quant, 300, "Barra refinada de fragmentos de gelo");
    }
}
