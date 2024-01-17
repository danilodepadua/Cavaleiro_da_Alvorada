package com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacete;

public class CapaceteMalha extends Capacete {
    public CapaceteMalha() {
        this.imagem = "/com.daniel.Images/Itens/Capacete malha.png";
        this.nome ="Capacete de Malha";
        this.preço = 200;
        this.aumentoDefesaFisica = 60;
        this.aumentoDefesaMagica = 15;
        this.descricao = "Concede um aumento de "+this.aumentoDefesaFisica+ " na defesa física e um aumento de " + this.aumentoDefesaMagica+ " na defesa mágica";

    }
}
