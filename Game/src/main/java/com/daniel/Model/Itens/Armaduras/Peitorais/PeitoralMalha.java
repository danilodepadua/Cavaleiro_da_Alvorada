package com.daniel.Model.Itens.Armaduras.Peitorais;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Armaduras.Peitoral;

public class PeitoralMalha extends Peitoral {
    public PeitoralMalha() {
        super("/com.daniel.Images/Itens/Peitoral Malha.png", new TextoNode("Peitoral de Malha","knitted armor"), 1, 18000, new TextoNode("Concede um aumento de 120 na defesa física e um aumento de 40 na defesa mágica", "Increases physical defense by 120 and magic defense by 40"), 120, 40);
    }

    public PeitoralMalha(int quant) {
        super("/com.daniel.Images/Itens/Peitoral Malha.png", new TextoNode("Peitoral de Malha","knitted armor"), quant, 18000, new TextoNode("Concede um aumento de 120 na defesa física e um aumento de 40 na defesa mágica", "Increases physical defense by 120 and magic defense by 40"), 120, 40);
    }
}
