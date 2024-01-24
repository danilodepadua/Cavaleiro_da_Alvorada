package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaInicial extends Arma {
    public EspadaInicial() {
        super("/com.daniel.Images/Armas/w_longsword02.png", "Espada básica", 1, 20, "Concede aumento de 30 no ataque físico", 30, 0, TiposElementais.NaoElemental);
    }

    public EspadaInicial(int quant) {
        super("/com.daniel.Images/Armas/w_longsword02.png", "Espada básica", quant, 20, "Concede aumento de 30 no ataque físico", 30, 0, TiposElementais.NaoElemental);
    }
}
