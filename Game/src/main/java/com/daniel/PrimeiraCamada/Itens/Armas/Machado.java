package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class Machado extends Arma {

    public Machado() {
        super("/com.daniel.Images/Armas/machado.png", "Machado", 1, 40, "Concede aumento de 50 no ataque físico", 50, 0, TiposElementais.NaoElemental);
    }

    public Machado(int quant) {
        super("/com.daniel.Images/Armas/machado.png", "Machado", quant, 40, "Concede aumento de 50 no ataque físico", 50, 0, TiposElementais.NaoElemental);
    }
}
