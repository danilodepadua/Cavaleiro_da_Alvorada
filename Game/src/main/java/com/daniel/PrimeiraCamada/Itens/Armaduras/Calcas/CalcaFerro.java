package com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Calca;
import com.daniel.PrimeiraCamada.TiposElementais;

public class CalcaFerro extends Calca {
    public CalcaFerro() {
        this.imagem = "/com.daniel.Images/Itens/CalcaFerro.png";
        this.nome ="Calça de Ferro";
        this.preço = 560;
        this.aumentoDefesaFisica = 200;
        this.aumentoDefesaMagica = 56;
        this.descricao = "Concede um aumento de "+this.aumentoDefesaFisica+ " na defesa física e um aumento de " + this.aumentoDefesaMagica+ " na defesa mágica";
        this.absorcao = new TiposElementais[]{TiposElementais.NaoElemental, TiposElementais.Eletrico};
    }
}
