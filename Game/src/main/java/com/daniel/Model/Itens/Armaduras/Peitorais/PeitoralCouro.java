package com.daniel.Model.Itens.Armaduras.Peitorais;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Armaduras.Peitoral;

public class PeitoralCouro extends Peitoral  {

    public PeitoralCouro() {
        super("/com.daniel.Images/Itens/PeitoralCouro.png", new TextoNode("Peitoral de Couro","Leather armor"), 1, 5000, new TextoNode("Concede um aumento de 60 na defesa física e um aumento de 20 na defesa mágica", "Increases physical defense by 60 and magic defense by 20"), 60, 20);
    }

    public PeitoralCouro(int quant) {
        super("/com.daniel.Images/Itens/PeitoralCouro.png", new TextoNode("Peitoral de Couro","Leather armor"), quant, 5000, new TextoNode("Concede um aumento de 60 na defesa física e um aumento de 20 na defesa mágica", "Increases physical defense by 60 and magic defense by 20"), 60, 20);
    }
}
