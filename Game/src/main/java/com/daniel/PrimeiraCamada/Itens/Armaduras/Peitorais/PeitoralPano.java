package com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitoral;

public class PeitoralPano extends Peitoral {
    public PeitoralPano() {
        this.imagem = "/com.daniel.Images/Itens/Peitoral Pano.png";
        this.nome ="Peitoral de Pano";
        this.preço = 100;
        this.aumentoDefesaFisica = 30;
        this.aumentoDefesaMagica = 10;
        this.descricao = "Concede um aumento de "+this.aumentoDefesaFisica+ " na defesa física e um aumento de " + this.aumentoDefesaMagica+ " na defesa mágica";

    }
}
