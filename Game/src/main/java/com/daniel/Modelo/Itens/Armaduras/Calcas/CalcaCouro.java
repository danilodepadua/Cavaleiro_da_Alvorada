package com.daniel.Modelo.Itens.Armaduras.Calcas;

import com.daniel.Modelo.Itens.Armaduras.Calca;

public class CalcaCouro extends Calca {
    public CalcaCouro() {
        super("/com.daniel.Images/Itens/CalcaCouro.png","Calça de Couro", 1, 140, "Concede um aumento de 50 na defesa física e um aumento de 14 na defesa mágica", 50, 14);
    }

    public CalcaCouro(int quant) {
        super("/com.daniel.Images/Itens/CalcaCouro.png","Calça de Couro", quant, 140, "Concede um aumento de 50 na defesa física e um aumento de 14 na defesa mágica", 50, 14);
    }
}
