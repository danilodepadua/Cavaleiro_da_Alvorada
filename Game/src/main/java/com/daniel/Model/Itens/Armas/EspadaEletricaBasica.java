package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class EspadaEletricaBasica extends Arma {
    public EspadaEletricaBasica() {
        super("/com.daniel.Images/Armas/Espada eletrica.png", "Espada Elétrica", 1, 400, "Concede aumento de 25 no ataque mágico", 0, 25, TiposElementais.Eletrico);
    }

    public EspadaEletricaBasica(int quant) {
        super("/com.daniel.Images/Armas/Espada eletrica.png", "Espada Elétrica", quant, 400, "Concede aumento de 25 no ataque mágico", 0, 25, TiposElementais.Eletrico);
    }
}
