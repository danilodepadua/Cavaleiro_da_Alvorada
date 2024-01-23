package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaEletrica extends Arma {
    public EspadaEletrica(){
        this.imagem = "/com.daniel.Images/Armas/w_sword_roman_holly.png";
        this.aumentoDeAtaqueMagico = 35;
        this.tipoDano = TiposElementais.Eletrico;
        this.nome = "Espada Elétrica";
        this.descricao = "Concede aumento de "+this.aumentoDeAtaqueMagico+" no ataque mágico";
        this.preço = 120;
    }
}
