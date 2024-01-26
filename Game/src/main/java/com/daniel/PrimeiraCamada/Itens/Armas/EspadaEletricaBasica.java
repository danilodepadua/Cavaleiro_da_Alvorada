package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaEletricaBasica extends Arma {
    public EspadaEletricaBasica() {
        super("/com.daniel.Images/Armas/Espada eletrica.png", "Espada Elétrica", 1, 170, "Concede aumento de 60 no ataque mágico", 0, 60, TiposElementais.Eletrico);
    }

    public EspadaEletricaBasica(int quant) {
        super("/com.daniel.Images/Armas/Espada eletrica.png", "Espada Elétrica", quant, 170, "Concede aumento de 60 no ataque mágico", 0, 60, TiposElementais.Eletrico);
    }
}
