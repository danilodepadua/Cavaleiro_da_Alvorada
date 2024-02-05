package com.daniel.Model.Dados.Itens.Minerios;

import com.daniel.Model.Dados.Itens.Minerio;

public class BarraFogo extends Minerio {
    public BarraFogo(){
        super("/com.daniel.Images/Itens/Minerios/BarraFogo.png", "Barra de Fogo", 1, 150, "Barra refinada de fragmentos de Fogo");
    }

    public BarraFogo(int quant) {
        super("/com.daniel.Images/Itens/Minerios/BarraFogo.png", "Barra de Fogo", quant, 150, "Barra refinada de fragmentos de Fogo");
    }
}