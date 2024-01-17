package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class Katana extends Arma {
    public Katana(){
        this.imagem = "/com.daniel.Images/Armas/w_katana.png";
        this.aumentoDeAtaqueFisico = 50;
        this.tipoDano = TiposElementais.NaoElemental;
        this.nome = "Katana";
        this.descricao = "Concede aumento de "+this.aumentoDeAtaqueFisico+" no ataque físico";
        this.preço = 70;
    }
}
