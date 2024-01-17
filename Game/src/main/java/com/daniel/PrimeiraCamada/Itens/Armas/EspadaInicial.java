package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaInicial extends Arma {
    public EspadaInicial(){
        this.imagem = "/com.daniel.Images/Armas/w_longsword02.png";
        this.aumentoDeAtaqueFisico = 30;
        this.tipoDano = TiposElementais.NaoElemental;
        this.nome = "Espada básica";
        this.descricao = "Concede aumento de "+this.aumentoDeAtaqueFisico+" no ataque físico";
        this.preço = 20;
    }
}
