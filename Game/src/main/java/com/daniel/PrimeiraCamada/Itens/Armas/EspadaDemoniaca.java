package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaDemoniaca extends Arma {
    public EspadaDemoniaca() {
        super("/com.daniel.Images/Armas/EspadaFogoAprimorada.png", "Espada Demoníaca", 1, 700, "Concede aumento de 40 no ataque mágico", 0, 40, TiposElementais.Fogo);
    }

    public EspadaDemoniaca(int quant) {
        super("/com.daniel.Images/Armas/EspadaFogoAprimorada.png", "Espada Demoníaca", quant, 700, "Concede aumento de 40 no ataque mágico", 0, 40, TiposElementais.Fogo);
    }
}
