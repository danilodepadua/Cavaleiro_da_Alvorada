package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaEletricaBasica extends Arma {
    public EspadaEletricaBasica() {
        super("/com.daniel.Images/Armas/Espada eletrica.png", "Espada Elétrica", 1, 400, "Concede aumento de 25 no ataque mágico", 0, 25, TiposElementais.Eletrico);
    }

    public EspadaEletricaBasica(int quant) {
        super("/com.daniel.Images/Armas/Espada eletrica.png", "Espada Elétrica", quant, 400, "Concede aumento de 25 no ataque mágico", 0, 25, TiposElementais.Eletrico);
    }
}
