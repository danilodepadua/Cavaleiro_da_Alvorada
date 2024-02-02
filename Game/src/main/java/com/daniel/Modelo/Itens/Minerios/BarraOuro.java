package com.daniel.Modelo.Itens.Minerios;

import com.daniel.Modelo.Itens.Minerio;

public class BarraOuro extends Minerio {
    public BarraOuro(){
        super("/com.daniel.Images/Itens/Minerios/BarraOuro.png", "Barra de Ouro", 1, 150, "Barra refinada de Ouro");
    }

    public BarraOuro(int quant) {
        super("/com.daniel.Images/Itens/Minerios/BarraOuro.png", "Barra de Ouro", quant, 150, "Barra refinada de Ouro");
    }
}

