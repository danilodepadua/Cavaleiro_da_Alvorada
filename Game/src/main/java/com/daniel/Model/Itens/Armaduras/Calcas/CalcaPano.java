package com.daniel.Model.Itens.Armaduras.Calcas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Armaduras.Calca;

public class CalcaPano extends Calca {
    public CalcaPano() {
        super("/com.daniel.Images/Itens/Calca Pano.png", new TextoNode("Calça de Pano","cloth pants"), 1, 70, new TextoNode("Concede um aumento de 25 na defesa física e um aumento de 7 na defesa mágica", "Increases physical defense by 25 and magic defense by 7"), 25, 7);
    }

    public CalcaPano(int quant) {
        super("/com.daniel.Images/Itens/Calca Pano.png", new TextoNode("Calça de Pano","cloth pants"), quant, 70, new TextoNode("Concede um aumento de 25 na defesa física e um aumento de 7 na defesa mágica", "Increases physical defense by 25 and magic defense by 7"), 25, 7);
    }
}
