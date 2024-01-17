package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class Tridente extends Arma {
    public Tridente(){
        this.imagem = "/com.daniel.Images/Armas/w_trident.png";
        this.aumentoDeAtaqueFisico = 90;
        this.tipoDano = TiposElementais.NaoElemental;
        this.nome = "Tridente";
        this.descricao = "Concede aumento de "+this.aumentoDeAtaqueFisico+" no ataque físico";
        this.preço = 150;
    }
}
