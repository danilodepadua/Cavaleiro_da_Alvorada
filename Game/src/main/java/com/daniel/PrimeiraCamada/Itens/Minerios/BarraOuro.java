package com.daniel.PrimeiraCamada.Itens.Minerios;

import com.daniel.PrimeiraCamada.Itens.Item;

public class BarraOuro extends Item {
    public BarraOuro(){
        super("/com.daniel.Images/Itens/Minerios/BarraOuro.png", "Barra de Ouro", 1, 150, "Barra refinada de Ouro");
    }

    public BarraOuro(int quant) {
        super("/com.daniel.Images/Itens/Minerios/BarraOuro.png", "Barra de Ouro", quant, 150, "Barra refinada de Ouro");
    }
}

