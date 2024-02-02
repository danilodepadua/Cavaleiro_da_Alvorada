package com.daniel.Model.Itens.Armaduras.Peitorais;

import com.daniel.Model.Itens.Armaduras.Peitoral;

public class PeitoralPano extends Peitoral {
    public PeitoralPano() {
        super("/com.daniel.Images/Itens/Peitoral Pano.png", "Peitoral de Pano", 1, 100, "Concede um aumento de 30 na defesa física e um aumento de 10 na defesa mágica", 30, 10);
    }

    public PeitoralPano(int quant) {
        super("/com.daniel.Images/Itens/Peitoral Pano.png", "Peitoral de Pano", quant, 100, "Concede um aumento de 30 na defesa física e um aumento de 10 na defesa mágica", 30, 10);
    }

}
