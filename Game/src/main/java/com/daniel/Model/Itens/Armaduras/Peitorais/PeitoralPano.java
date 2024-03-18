package com.daniel.Model.Itens.Armaduras.Peitorais;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Armaduras.Peitoral;

public class PeitoralPano extends Peitoral {
    public PeitoralPano() {
        super("/com.daniel.Images/Itens/Peitoral Pano.png", new TextoNode("Peitoral de Pano","cloth armor"), 1, 100, new TextoNode("Concede um aumento de 30 na defesa física e um aumento de 10 na defesa mágica", "Increases physical defense by 30 and magic defense by 10"), 30, 10);
    }

    public PeitoralPano(int quant) {
        super("/com.daniel.Images/Itens/Peitoral Pano.png", new TextoNode("Peitoral de Pano","cloth armor"), quant, 100, new TextoNode("Concede um aumento de 30 na defesa física e um aumento de 10 na defesa mágica", "Increases physical defense by 30 and magic defense by 10"), 30, 10);
    }

}
