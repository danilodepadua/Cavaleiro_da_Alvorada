package com.daniel.Model.Itens.Armaduras.Calcas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Armaduras.Calca;

public class CalcaCouro extends Calca {
    public CalcaCouro() {
        super("/com.daniel.Images/Itens/CalcaCouro.png",new TextoNode("Calça de Couro","leather pants"), 1, 140, new TextoNode("Concede um aumento de 50 na defesa física e um aumento de 14 na defesa mágica", "Increases physical defense by 50 and magic defense by 14"), 50, 14);
    }

    public CalcaCouro(int quant) {
        super("/com.daniel.Images/Itens/CalcaCouro.png",new TextoNode("Calça de Couro","leather pants"), quant, 140, new TextoNode("Concede um aumento de 50 na defesa física e um aumento de 14 na defesa mágica", "Increases physical defense by 50 and magic defense by 14"), 50, 14);
    }
}
