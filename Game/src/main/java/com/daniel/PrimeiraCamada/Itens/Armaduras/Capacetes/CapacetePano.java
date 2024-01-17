package com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacete;

public class CapacetePano extends Capacete {
    public CapacetePano() {
        this.imagem = "/com.daniel.Images/Itens/Capacete Pano.png";
        this.nome ="Capacete de Pano";
        this.preço = 50;
        this.aumentoDefesaFisica = 15;
        this.aumentoDefesaMagica = 3;
        this.descricao = "Concede um aumento de "+this.aumentoDefesaFisica+ " na defesa física e um aumento de " + this.aumentoDefesaMagica+ " na defesa mágica";

    }
}
