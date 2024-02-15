package com.daniel.Model.Itens.Armaduras.Calcas;

import com.daniel.Model.Itens.Armaduras.Calca;

public class CalcaPano extends Calca {
    public CalcaPano() {
        super("/com.daniel.Images/Itens/Calca Pano.png", "Calça de Pano", 1, 70, "Concede um aumento de 25 na defesa física e um aumento de 7 na defesa mágica", 25, 7);
    }

    public CalcaPano(int quant) {
        super("/com.daniel.Images/Itens/Calca Pano.png", "Calça de Pano", quant, 70, "Concede um aumento de 25 na defesa física e um aumento de 7 na defesa mágica", 25, 7);
    }
}
