package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposDano;

public class Espada extends Arma {
    public Espada(){
        this.imagem = "/com.daniel.Images/Itens/Espada.png";
        this.aumentoDeAtaqueFisico = 30;
        this.tipoDano = TiposDano.Fisico;
        this.nome = "Espada de diamante";
        this.descricao = "Concede aumento no ataque fisico";
        this.preço = 20;
    }
}
