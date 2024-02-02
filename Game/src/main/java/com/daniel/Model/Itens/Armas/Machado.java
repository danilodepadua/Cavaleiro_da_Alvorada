package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class Machado extends Arma {

    public Machado() {
        super("/com.daniel.Images/Armas/machado.png", "Machado", 1, 40, "Concede aumento de 35 no ataque físico", 35, 0, TiposElementais.NaoElemental);
    }

    public Machado(int quant) {
        super("/com.daniel.Images/Armas/machado.png", "Machado", quant, 40, "Concede aumento de 35 no ataque físico", 35, 0, TiposElementais.NaoElemental);
    }
}
