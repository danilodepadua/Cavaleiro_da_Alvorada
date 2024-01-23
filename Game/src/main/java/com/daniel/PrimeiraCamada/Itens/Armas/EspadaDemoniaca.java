package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaDemoniaca extends Arma {
    public EspadaDemoniaca(){
        this.imagem = "/com.daniel.Images/Armas/w_sword_roman_blood.png";
        this.aumentoDeAtaqueMagico = 50;
        this.tipoDano = TiposElementais.Fogo;
        this.nome = "Espada Destruidora";
        this.descricao = "Concede aumento de "+this.aumentoDeAtaqueMagico+" no ataque mágico";
        this.preço = 200;
    }
}
