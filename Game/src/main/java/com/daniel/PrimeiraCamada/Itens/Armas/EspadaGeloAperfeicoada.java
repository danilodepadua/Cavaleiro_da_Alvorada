package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaGeloAperfeicoada extends Arma {
    public EspadaGeloAperfeicoada() {
        super("/com.daniel.Images/Armas/w_sword_roman_diamond.png", "Espada glacial", 1, 150, "Concede aumento de 50 no ataque mágico", 0, 50, TiposElementais.Gelo);
    }

    public EspadaGeloAperfeicoada(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman_diamond.png", "Espada glacial", quant, 90, "Concede aumento de 50 no ataque mágico", 0, 50, TiposElementais.Gelo);
    }
}
