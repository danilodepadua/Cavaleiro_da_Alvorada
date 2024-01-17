package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaSombria extends Arma {
    public EspadaSombria(){
        this.imagem = "/com.daniel.Images/Armas/w_sword_roman_dark.png";
        this.aumentoDeAtaqueMagico = 30;
        this.tipoDano = TiposElementais.Escuridao;
        this.nome = "Espada sombria";
        this.descricao = "Concede aumento de "+this.aumentoDeAtaqueMagico+" no ataque mágico";
        this.preço = 100;
    }
}
