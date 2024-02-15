package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class EspadaAperfeiçoada extends Arma {

    public EspadaAperfeiçoada() {
        super("/com.daniel.Images/Armas/w_sword_roman.png", "Espada Melhorada", 1, 200, "Concede aumento de 35 no ataque físico", 35, 0, TiposElementais.NaoElemental);
    }

    public EspadaAperfeiçoada(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman.png", "Espada Melhorada", quant, 200, "Concede aumento de 35 no ataque físico", 35, 0, TiposElementais.NaoElemental);
    }
}
