package com.daniel.Model.Itens.Armaduras.Capacetes;

import com.daniel.Model.Itens.Armaduras.Capacete;

public class CapaceteMalha extends Capacete {
    public CapaceteMalha() {
        super("/com.daniel.Images/Itens/Capacete malha.png", "Capacete de Malha", 1, 200, "Concede um aumento de 60 na defesa física e um aumento de 15 na defesa mágica", 60, 15);
    }

    public CapaceteMalha(int quant) {
        super("/com.daniel.Images/Itens/Capacete malha.png", "Capacete de Malha", quant, 200, "Concede um aumento de 60 na defesa física e um aumento de 15 na defesa mágica", 60, 15);
    }
}
