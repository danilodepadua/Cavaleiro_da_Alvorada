package com.daniel.Model.Itens.Armaduras.Peitorais;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Armaduras.Peitoral;

public class PeitoralFerro extends Peitoral  {

    public PeitoralFerro() {
        super("/com.daniel.Images/Itens/PeitoralFerro.png", new TextoNode("Peitoral de Ferro","Iron Armor"), 1, 50000, new TextoNode("Concede um aumento de 240 na defesa física e um aumento de 80 na defesa mágica", "Increases physical defense by 240 and magic defense by 80"), 240, 80);
    }

    public PeitoralFerro(int quant) {
        super("/com.daniel.Images/Itens/PeitoralFerro.png", new TextoNode("Peitoral de Ferro","Iron Armor"), quant, 50000, new TextoNode("Concede um aumento de 240 na defesa física e um aumento de 80 na defesa mágica", "Increases physical defense by 240 and magic defense by 80"), 240, 80);
    }

}
