package com.daniel.Model.Itens.Minerios;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class Ferro extends Minerio {
    public Ferro(){
        super("/com.daniel.Images/Itens/Minerios/Ferro.png", new TextoNode("Minério de Ferro","Iron ore"), 1, 5000, new TextoNode("Minério de Ferro","Iron ore"));
    }

    public Ferro(int quant) {
        super("/com.daniel.Images/Itens/Minerios/Ferro.png", new TextoNode("Minério de Ferro","Iron ore"), quant, 5000, new TextoNode("Minério de Ferro","Iron ore"));
    }
}
