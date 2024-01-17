package com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitoral;

public class PeitoralCouro extends Peitoral  {

    public PeitoralCouro() {
        this.imagem = "/com.daniel.Images/Itens/PeitoralCouro.png";
        this.nome = "Armadura de Couro";
        this.preço = 200;
        this.aumentoDefesaFisica = 60;
        this.aumentoDefesaMagica = 20;
        this.descricao = "Concede um aumento de "+this.aumentoDefesaFisica+ " na defesa física e um aumento de " + this.aumentoDefesaMagica+ " na defesa mágica";

    }

}
