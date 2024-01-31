package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaGeloBasica extends Arma {
    public EspadaGeloBasica() {
        super("/com.daniel.Images/Armas/Espada de gelo.png", "Espada de gelo", 1, 900, "Concede aumento de 27 no ataque mágico", 0, 27, TiposElementais.Gelo);
    }

    public EspadaGeloBasica(int quant) {
        super("/com.daniel.Images/Armas/Espada de gelo.png", "Espada de gelo", quant, 900, "Concede aumento de 27 no ataque mágico", 0, 27, TiposElementais.Gelo);
    }
}
