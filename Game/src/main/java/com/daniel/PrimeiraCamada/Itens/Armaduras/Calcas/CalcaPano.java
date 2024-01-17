package com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Calca;

public class CalcaPano extends Calca {
    public CalcaPano() {
        this.imagem = "/com.daniel.Images/Itens/Calca Pano.png";
        this.nome ="Calça de Pano";
        this.preço = 70;
        this.aumentoDefesaFisica = 25;
        this.aumentoDefesaMagica = 7;
        this.descricao = "Concede um aumento de "+this.aumentoDefesaFisica+ " na defesa física e um aumento de " + this.aumentoDefesaMagica+ " na defesa mágica";

    }
}
