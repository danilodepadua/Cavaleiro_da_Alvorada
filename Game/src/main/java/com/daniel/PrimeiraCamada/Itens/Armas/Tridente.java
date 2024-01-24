package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class Tridente extends Arma {
    public Tridente() {
        super("/com.daniel.Images/Armas/w_trident.png", "Tridente", 1, 150, "Concede aumento de 90 no ataque físico", 90, 0, TiposElementais.NaoElemental);
    }

    public Tridente(int quant) {
        super("/com.daniel.Images/Armas/w_trident.png", "Tridente", quant, 150, "Concede aumento de 90 no ataque físico", 90, 0, TiposElementais.NaoElemental);
    }
}
