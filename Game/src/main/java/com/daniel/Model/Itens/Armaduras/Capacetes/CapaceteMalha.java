package com.daniel.Model.Itens.Armaduras.Capacetes;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Armaduras.Capacete;

public class CapaceteMalha extends Capacete {
    public CapaceteMalha() {
        super("/com.daniel.Images/Itens/Capacete malha.png", new TextoNode("Capacete de Malha","knitted helmet"), 1, 12000, new TextoNode("Concede um aumento de 60 na defesa física e um aumento de 15 na defesa mágica", "Increases physical defense by 60 and magic defense by 15"), 60, 15);
    }

    public CapaceteMalha(int quant) {
        super("/com.daniel.Images/Itens/Capacete malha.png", new TextoNode("Capacete de Malha","knitted helmet"), quant, 12000, new TextoNode("Concede um aumento de 60 na defesa física e um aumento de 15 na defesa mágica", "Increases physical defense by 60 and magic defense by 15"), 60, 15);
    }
}
