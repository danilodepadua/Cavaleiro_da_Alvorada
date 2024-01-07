package com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitoral;

public class PeitoralFerro extends Peitoral  {

    public PeitoralFerro() {
        this.imagem = "/com.daniel.Images/Itens/PeitoralFerro.png";
        this.nome = "Armadura de Ferro";
        this.preço = 70;
        this.aumentoDefesaFisica = 70;
        this.descricao = "Concede um grande aumento de "+ this.aumentoDefesaFisica+ " na defesa física";

    }

}
