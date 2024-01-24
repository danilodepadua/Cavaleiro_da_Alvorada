package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaGelo extends Arma {
    public EspadaGelo() {
        super("/com.daniel.Images/Armas/w_sword_roman_diamond.png", "Espada glacial", 1, 90, "Concede aumento de 25 no ataque mágico", 0, 25, TiposElementais.Gelo);
    }

    public EspadaGelo(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman_diamond.png", "Espada glacial", quant, 90, "Concede aumento de 25 no ataque mágico", 0, 25, TiposElementais.Gelo);
    }
}
