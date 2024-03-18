package com.daniel.Model.Itens.Minerios;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class BarraFerro extends Minerio {
    public BarraFerro(){
        super("/com.daniel.Images/Itens/Minerios/BarraFerro.png", new TextoNode("Barra de Ferro","Iron bar"), 1, 50, new TextoNode("Barra refinada de Ferro","Refined iron bar"));
    }

    public BarraFerro(int quant) {
        super("/com.daniel.Images/Itens/Minerios/BarraFerro.png", new TextoNode("Barra de Ferro","Iron bar"), quant, 50, new TextoNode("Barra refinada de Ferro","Refined iron bar"));
    }
}
