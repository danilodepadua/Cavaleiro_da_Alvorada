package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class KatanaFogo extends Arma {
    public KatanaFogo(){
        this.imagem = "/com.daniel.Images/Armas/w_katana_fire.png";
        this.aumentoDeAtaqueFisico = 80;
        this.tipoDano = TiposElementais.Fogo;
        this.nome = "Katana de fogo";
        this.descricao = "Concede aumento de "+this.aumentoDeAtaqueFisico+" no ataque físico";
        this.preço = 150;
    }
}
