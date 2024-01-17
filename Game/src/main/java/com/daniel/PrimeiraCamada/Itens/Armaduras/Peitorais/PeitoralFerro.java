package com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitoral;

public class PeitoralFerro extends Peitoral  {

    public PeitoralFerro() {
        this.imagem = "/com.daniel.Images/Itens/PeitoralFerro.png";
        this.nome = "Peitoral de Ferro";
        this.preço = 600;
        this.aumentoDefesaFisica = 240;
        this.aumentoDefesaMagica = 80;
        this.descricao = "Concede um aumento de "+this.aumentoDefesaFisica+ " na defesa física e um aumento de " + this.aumentoDefesaMagica+ " na defesa mágica";

    }

}
