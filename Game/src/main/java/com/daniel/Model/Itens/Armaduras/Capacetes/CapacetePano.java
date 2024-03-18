package com.daniel.Model.Itens.Armaduras.Capacetes;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Armaduras.Capacete;

public class CapacetePano extends Capacete {
    public CapacetePano() {
        super("/com.daniel.Images/Itens/Capacete Pano.png", new TextoNode("Capacete de Pano","cloth helmet"), 1, 50, new TextoNode("Concede um aumento de 15 na defesa física e um aumento de 3 na defesa mágica", "Increases physical defense by 15 and magic defense by 3"), 15, 3);
    }

    public CapacetePano(int quant) {
        super("/com.daniel.Images/Itens/Capacete Pano.png", new TextoNode("Capacete de Pano","cloth helmet"), quant, 50, new TextoNode("Concede um aumento de 15 na defesa física e um aumento de 3 na defesa mágica", "Increases physical defense by 15 and magic defense by 3"), 15, 3);
    }
}
