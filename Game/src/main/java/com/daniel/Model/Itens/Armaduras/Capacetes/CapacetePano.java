package com.daniel.Model.Itens.Armaduras.Capacetes;

import com.daniel.Model.Itens.Armaduras.Capacete;

public class CapacetePano extends Capacete {
    public CapacetePano() {
        super("/com.daniel.Images/Itens/Capacete Pano.png", "Capacete de Pano", 1, 50, "Concede um aumento de 15 na defesa física e um aumento de 3 na defesa mágica", 15, 3);
    }

    public CapacetePano(int quant) {
        super("/com.daniel.Images/Itens/Capacete Pano.png", "Capacete de Pano", quant, 50, "Concede um aumento de 15 na defesa física e um aumento de 3 na defesa mágica", 15, 3);
    }
}
