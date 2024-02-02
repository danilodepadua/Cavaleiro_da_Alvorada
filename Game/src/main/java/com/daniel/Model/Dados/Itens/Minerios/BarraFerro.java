package com.daniel.Model.Dados.Itens.Minerios;

import com.daniel.Model.Dados.Itens.Minerio;

public class BarraFerro extends Minerio {
    public BarraFerro(){
        super("/com.daniel.Images/Itens/Minerios/BarraFerro.png", "Barra de Ferro", 1, 50, "Barra refinada de Ferro");
    }

    public BarraFerro(int quant) {
        super("/com.daniel.Images/Itens/Minerios/BarraFerro.png", "Barra de Ferro", quant, 50, "Barra refinada de Ferro");
    }
}
