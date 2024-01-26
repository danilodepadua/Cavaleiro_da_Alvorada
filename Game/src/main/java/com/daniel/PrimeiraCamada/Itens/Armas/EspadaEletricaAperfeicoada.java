package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaEletricaAperfeicoada extends Arma {
    public EspadaEletricaAperfeicoada() {
        super("/com.daniel.Images/Armas/w_sword_roman_holly.png", "Espada Elétrica", 1, 120, "Concede aumento de 35 no ataque mágico", 0, 35, TiposElementais.Eletrico);
    }

    public EspadaEletricaAperfeicoada(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman_holly.png", "Espada Elétrica", quant, 120, "Concede aumento de 35 no ataque mágico", 0, 35, TiposElementais.Eletrico);
    }
}
