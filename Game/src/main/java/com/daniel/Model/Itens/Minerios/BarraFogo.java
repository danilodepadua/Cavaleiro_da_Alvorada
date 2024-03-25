package com.daniel.Model.Itens.Minerios;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class BarraFogo extends Minerio {
    public BarraFogo(){
        super("/com.daniel.Images/Itens/Minerios/BarraFogo.png", new TextoNode("Barra de Fogo","Fire bar"), 1, 15000, new TextoNode("Barra refinada de fragmentos de Fogo","Refined bar of fire fragments"));
    }

    public BarraFogo(int quant) {
        super("/com.daniel.Images/Itens/Minerios/BarraFogo.png", new TextoNode("Barra de Fogo","Fire bar"), quant, 15000, new TextoNode("Barra refinada de fragmentos de Fogo","Refined bar of fire fragments"));
    }
}
