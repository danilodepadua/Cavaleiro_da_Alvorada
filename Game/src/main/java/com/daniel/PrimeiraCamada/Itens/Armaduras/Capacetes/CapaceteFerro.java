package com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacete;

public class CapaceteFerro extends Capacete  {
    public CapaceteFerro(){
        this.imagem = "/com.daniel.Images/Itens/CapaceteFerro.png";
        this.descricao = "Concede um aumento de defesa física e de defesa mágica";
        this.nome ="Capacete de Ferro";
        this.preço = 10;
        this.aumentoDefesaFisica = 20;
        this.aumentoDefesaMagica = 10;
    }


}
