package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;

public class Cajado extends Arma {
    public Cajado() {
        this.imagem = "/com.daniel.Images/Itens/Cajado.png";
        this.nome = "Cajado Mágico";
        this.aumentoDeAtaqueMagico = 10;
        this.descricao = "Concede um aumento de "+this.aumentoDeAtaqueMagico+" mágico";
        this.preço = 10;
    }
}
