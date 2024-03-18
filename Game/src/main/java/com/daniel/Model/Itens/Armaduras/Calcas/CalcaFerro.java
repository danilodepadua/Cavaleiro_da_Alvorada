package com.daniel.Model.Itens.Armaduras.Calcas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Armaduras.Calca;
import com.daniel.Model.Magias.TiposElementais;

public class CalcaFerro extends Calca {
    public CalcaFerro() {
        super("/com.daniel.Images/Itens/CalcaFerro.png", new TextoNode("Calça de Ferro","Iron Pants"), 1, 560, new TextoNode("Concede um aumento de 200 na defesa física e um aumento de 56 na defesa mágica", "Increases physical defense by 200 and magic defense by 56"), 200, 56);
        this.absorcao = new TiposElementais[]{TiposElementais.NaoElemental, TiposElementais.Eletrico};
    }

    public CalcaFerro(int quant) {
        super("/com.daniel.Images/Itens/CalcaFerro.png", new TextoNode("Calça de Ferro","Iron Pants"), quant, 560, new TextoNode("Concede um aumento de 200 na defesa física e um aumento de 56 na defesa mágica", "Increases physical defense by 200 and magic defense by 56"), 200, 56);
        this.absorcao = new TiposElementais[]{TiposElementais.NaoElemental, TiposElementais.Eletrico};
    }
}
