package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class KatanaGelo extends Arma {
    public KatanaGelo(){
        this.imagem = "/com.daniel.Images/Armas/w_katana_diamond.png";
        this.aumentoDeAtaqueFisico = 75;
        this.tipoDano = TiposElementais.Gelo;
        this.nome = "Katana Glacial";
        this.descricao = "Concede aumento de "+this.aumentoDeAtaqueFisico+" no ataque físico";
        this.preço = 130;
    }
}
