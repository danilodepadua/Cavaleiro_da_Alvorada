package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class Cajado extends Arma {
    public Cajado() {
        super("/com.daniel.Images/Itens/Cajado.png", "Cajado Mágico", 1, 10, "Concede um aumento de 10 no ataque mágico", 0, 10, TiposElementais.NaoElemental);
    }

    public Cajado(int quant) {
        super("/com.daniel.Images/Itens/Cajado.png", "Cajado Mágico", quant, 10, "Concede um aumento de 10 no ataque mágico", 0, 10, TiposElementais.NaoElemental);
    }
}
