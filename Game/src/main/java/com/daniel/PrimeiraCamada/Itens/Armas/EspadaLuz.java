package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaLuz extends Arma {
    public EspadaLuz(){
        this.imagem = "/com.daniel.Images/Armas/w_sword_roman_lightning.png";
        this.aumentoDeAtaqueMagico = 50;
        this.tipoDano = TiposElementais.Luz;
        this.nome = "Espada da Luz";
        this.descricao = "Concede aumento de "+this.aumentoDeAtaqueMagico+" no ataque mágico";
        this.preço = 200;
    }
}
