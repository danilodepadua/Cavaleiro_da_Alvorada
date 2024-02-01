package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaSombriaAperfeicoada extends Arma {
    public EspadaSombriaAperfeicoada() {
        super("/com.daniel.Images/Armas/w_sword_roman_dark.png", "Espada super sombria", 1, 1500, "Concede aumento de 60 no ataque mágico", 0, 60, TiposElementais.Escuridao);
    }

    public EspadaSombriaAperfeicoada(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman_dark.png", "Espada super sombria", quant, 1500, "Concede aumento de 60 no ataque mágico", 0, 60, TiposElementais.Escuridao);
    }
}
