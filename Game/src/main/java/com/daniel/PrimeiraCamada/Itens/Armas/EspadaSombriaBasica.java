package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaSombriaBasica extends Arma {
    public EspadaSombriaBasica() {
        super("/com.daniel.Images/Armas/Espada Sombria.png", "Espada Sombria", 1, 1100, "Concede aumento de 30 no ataque mágico", 0, 30, TiposElementais.Escuridao);
    }

    public EspadaSombriaBasica(int quant) {
        super("/com.daniel.Images/Armas/Espada Sombria.png", "Espada Sombria", quant, 1100, "Concede aumento de 30 no ataque mágico", 0, 30, TiposElementais.Escuridao);
    }
}

