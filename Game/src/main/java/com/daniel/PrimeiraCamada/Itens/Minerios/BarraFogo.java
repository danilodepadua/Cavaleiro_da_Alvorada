package com.daniel.PrimeiraCamada.Itens.Minerios;

import com.daniel.PrimeiraCamada.Itens.Item;

public class BarraFogo extends Item {
    public BarraFogo(){
        super("/com.daniel.Images/Itens/Minerios/BarraFogo.png", "Barra de Fogo", 1, 150, "Barra refinada de fragmentos de Fogo");
    }

    public BarraFogo(int quant) {
        super("/com.daniel.Images/Itens/Minerios/BarraFogo.png", "Barra de Fogo", quant, 150, "Barra refinada de fragmentos de Fogo");
    }
}
