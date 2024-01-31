package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaInicial extends Arma {
    public EspadaInicial() {
        super("/com.daniel.Images/Armas/Espada basica.png", "Espada básica", 1, 100, "Concede aumento de 15 no ataque físico", 15, 0, TiposElementais.NaoElemental);
    }

    public EspadaInicial(int quant) {
        super("/com.daniel.Images/Armas/Espada basica.png", "Espada básica", quant, 100, "Concede aumento de 15 no ataque físico", 15, 0, TiposElementais.NaoElemental);
    }
}
