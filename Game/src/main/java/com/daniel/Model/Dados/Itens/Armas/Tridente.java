package com.daniel.Model.Dados.Itens.Armas;

import com.daniel.Model.Dados.Itens.Arma;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Tridente extends Arma {
    public Tridente() {
        super("/com.daniel.Images/Armas/w_trident.png", "Tridente", 1, 3000, "Concede aumento de 70 no ataque físico", 90, 0, TiposElementais.NaoElemental);
    }

    public Tridente(int quant) {
        super("/com.daniel.Images/Armas/w_trident.png", "Tridente", quant, 3000, "Concede aumento de 70 no ataque físico", 90, 0, TiposElementais.NaoElemental);
    }
}
