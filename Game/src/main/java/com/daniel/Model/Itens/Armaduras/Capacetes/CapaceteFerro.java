package com.daniel.Model.Itens.Armaduras.Capacetes;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Armaduras.Capacete;

public class CapaceteFerro extends Capacete  {
    public CapaceteFerro() {
        super("/com.daniel.Images/Itens/CapaceteFerro.png", new TextoNode("Capacete de Ferro","Iron helmet"), 1, 40000, new TextoNode("Concede um aumento de 120 na defesa física e um aumento de 30 na defesa mágica", "Increases physical defense by 120 and magic defense by 30"), 120, 30);
    }

    public CapaceteFerro(int quant) {
        super("/com.daniel.Images/Itens/CapaceteFerro.png", new TextoNode("Capacete de Ferro","Iron helmet"), quant, 40000, new TextoNode("Concede um aumento de 120 na defesa física e um aumento de 30 na defesa mágica", "Increases physical defense by 120 and magic defense by 30"), 120, 30);
    }


}
