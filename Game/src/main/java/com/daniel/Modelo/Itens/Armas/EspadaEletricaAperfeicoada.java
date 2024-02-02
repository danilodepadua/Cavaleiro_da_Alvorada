package com.daniel.Modelo.Itens.Armas;

import com.daniel.Modelo.Itens.Arma;
import com.daniel.Modelo.Magia.TiposElementais;

public class EspadaEletricaAperfeicoada extends Arma {
    public EspadaEletricaAperfeicoada() {
        super("/com.daniel.Images/Armas/w_sword_roman_holly.png", "Espada super elétrica", 1, 1000, "Concede aumento de 50 no ataque mágico", 0, 50, TiposElementais.Eletrico);
    }

    public EspadaEletricaAperfeicoada(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman_holly.png", "Espada super elétrica", quant, 1000, "Concede aumento de 50 no ataque mágico", 0, 50, TiposElementais.Eletrico);
    }
}
