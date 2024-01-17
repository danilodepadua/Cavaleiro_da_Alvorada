package com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitoral;

public class PeitoralMalha extends Peitoral {
    public PeitoralMalha() {
        this.imagem = "/com.daniel.Images/Itens/Peitoral Malha.png";
        this.nome ="Peitoral de malha";
        this.preço = 400;
        this.aumentoDefesaFisica = 120;
        this.aumentoDefesaMagica = 40;
        this.descricao = "Concede um aumento de "+this.aumentoDefesaFisica+ " na defesa física e um aumento de " + this.aumentoDefesaMagica+ " na defesa mágica";

    }
}
