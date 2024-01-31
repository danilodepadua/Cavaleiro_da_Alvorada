package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaLuz extends Arma {
    public EspadaLuz() {
        super("/com.daniel.Images/Armas/w_sword_roman_lightning.png", "Espada da Luz", 1, 2000, "Concede aumento de 80 no ataque mágico", 0, 80, TiposElementais.Luz);
    }

    public EspadaLuz(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman_lightning.png", "Espada da Luz", quant, 2000, "Concede aumento de 80 no ataque mágico", 0, 80, TiposElementais.Luz);
    }
}
