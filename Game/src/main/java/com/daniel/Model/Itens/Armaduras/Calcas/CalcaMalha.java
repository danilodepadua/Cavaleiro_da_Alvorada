package com.daniel.Model.Itens.Armaduras.Calcas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Armaduras.Calca;

public class CalcaMalha extends Calca {
    public CalcaMalha() {
        super("/com.daniel.Images/Itens/Calca malha.png", new TextoNode("Calça de Malha","knitted pants"), 1, 28000, new TextoNode("Concede um aumento de 100 na defesa física e um aumento de 28 na defesa mágica", "Increases physical defense by 100 and magic defense by 28"), 100, 28);
    }

    public CalcaMalha(int quant) {
        super("/com.daniel.Images/Itens/Calca malha.png", new TextoNode("Calça de Malha","knitted pants"), quant, 28000, new TextoNode("Concede um aumento de 100 na defesa física e um aumento de 28 na defesa mágica", "Increases physical defense by 100 and magic defense by 28"), 100, 28);
    }
}
