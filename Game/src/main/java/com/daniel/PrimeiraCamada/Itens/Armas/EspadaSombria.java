package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaSombria extends Arma {
    public EspadaSombria() {
        super("/com.daniel.Images/Armas/w_sword_roman_dark.png", "Espada sombria", 1, 100, "Concede aumento de 30 no ataque mágico", 0, 30, TiposElementais.Escuridao);
    }

    public EspadaSombria(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman_dark.png", "Espada sombria", quant, 100, "Concede aumento de 30 no ataque mágico", 0, 30, TiposElementais.Escuridao);
    }
}
