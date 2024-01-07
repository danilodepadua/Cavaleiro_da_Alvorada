package com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacete;

public class CapaceteCouro extends Capacete {
    public CapaceteCouro() {
        this.imagem = "/com.daniel.Images/Itens/CapaceteCouro.png";
        this.nome ="Capacete de Couro";
        this.preço = 10;
        this.aumentoDefesaFisica = 10;
        this.aumentoDefesaMagica = 5;
        this.descricao = "Concede um aumento de "+this.aumentoDefesaFisica+ " na defesa física e um aumento de " + this.aumentoDefesaMagica+ " na defesa mágica";

    }
}
