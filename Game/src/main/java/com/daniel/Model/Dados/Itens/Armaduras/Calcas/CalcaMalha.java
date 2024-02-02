package com.daniel.Model.Dados.Itens.Armaduras.Calcas;

import com.daniel.Model.Dados.Itens.Armaduras.Calca;

public class CalcaMalha extends Calca {
    public CalcaMalha() {
        super("/com.daniel.Images/Itens/Calca malha.png", "Calça de Malha", 1, 280, "Concede um aumento de 100 na defesa física e um aumento de 28 na defesa mágica", 100, 28);
    }

    public CalcaMalha(int quant) {
        super("/com.daniel.Images/Itens/Calca malha.png", "Calça de Malha", quant, 280, "Concede um aumento de 100 na defesa física e um aumento de 28 na defesa mágica", 100, 28);
    }
}
