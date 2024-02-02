package com.daniel.Model.Dados.Itens.Armas;

import com.daniel.Model.Dados.Itens.Arma;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class EspadaSombriaAperfeicoada extends Arma {
    public EspadaSombriaAperfeicoada() {
        super("/com.daniel.Images/Armas/w_sword_roman_dark.png", "Espada super sombria", 1, 1500, "Concede aumento de 60 no ataque mágico", 0, 60, TiposElementais.Escuridao);
    }

    public EspadaSombriaAperfeicoada(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman_dark.png", "Espada super sombria", quant, 1500, "Concede aumento de 60 no ataque mágico", 0, 60, TiposElementais.Escuridao);
    }
}
