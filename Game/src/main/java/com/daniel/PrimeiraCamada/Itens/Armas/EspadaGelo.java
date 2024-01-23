package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaGelo extends Arma {
    public EspadaGelo(){
        this.imagem = "/com.daniel.Images/Armas/w_sword_roman_diamond.png";
        this.aumentoDeAtaqueMagico = 25;
        this.tipoDano = TiposElementais.Gelo;
        this.nome = "Espada glacial";
        this.descricao = "Concede aumento de "+this.aumentoDeAtaqueMagico+" no ataque mágico";
        this.preço = 90;
    }
}
