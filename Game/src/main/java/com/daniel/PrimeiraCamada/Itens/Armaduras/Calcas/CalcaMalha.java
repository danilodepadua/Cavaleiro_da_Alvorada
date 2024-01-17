package com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Calca;

public class CalcaMalha extends Calca {
    public CalcaMalha() {
        this.imagem = "/com.daniel.Images/Itens/Calca malha.png";
        this.nome ="Calça de Malha";
        this.preço = 280;
        this.aumentoDefesaFisica = 100;
        this.aumentoDefesaMagica = 28;
        this.descricao = "Concede um aumento de "+this.aumentoDefesaFisica+ " na defesa física e um aumento de " + this.aumentoDefesaMagica+ " na defesa mágica";

    }
}
