package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaEletricaAperfeicoada extends Arma {
    public EspadaEletricaAperfeicoada() {
        super("/com.daniel.Images/Armas/w_sword_roman_holly.png", "Espada Elétrica", 1, 1000, "Concede aumento de 50 no ataque mágico", 0, 50, TiposElementais.Eletrico);
    }

    public EspadaEletricaAperfeicoada(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman_holly.png", "Espada Elétrica", quant, 1000, "Concede aumento de 50 no ataque mágico", 0, 50, TiposElementais.Eletrico);
    }
}
