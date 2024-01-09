package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class Espada extends Arma {
    public Espada(){
        this.imagem = "/com.daniel.Images/Itens/Espada.png";
        this.aumentoDeAtaqueFisico = 30;
        this.tipoDano = TiposElementais.NaoElemental;
        this.nome = "Espada de diamante";
        this.descricao = "Concede aumento de "+this.aumentoDeAtaqueFisico+" no ataque físico";
        this.preço = 20;
    }
}
