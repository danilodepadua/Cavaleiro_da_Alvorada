package com.daniel.Model.Itens.Armaduras.Calcas;

import com.daniel.Model.Itens.Armaduras.Calca;
import com.daniel.Model.Magias.TiposElementais;

public class CalcaFerro extends Calca {
    public CalcaFerro() {
        super("/com.daniel.Images/Itens/CalcaFerro.png", "Calça de Ferro", 1, 560, "Concede um aumento de 200 na defesa física e um aumento de 56 na defesa mágica", 200, 56);
        this.absorcao = new TiposElementais[]{TiposElementais.NaoElemental, TiposElementais.Eletrico};
    }

    public CalcaFerro(int quant) {
        super("/com.daniel.Images/Itens/CalcaFerro.png", "Calça de Ferro", quant, 560, "Concede um aumento de 200 na defesa física e um aumento de 56 na defesa mágica", 200, 56);
        this.absorcao = new TiposElementais[]{TiposElementais.NaoElemental, TiposElementais.Eletrico};
    }
}
