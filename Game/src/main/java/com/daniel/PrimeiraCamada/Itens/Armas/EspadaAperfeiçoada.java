package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaAperfeiçoada extends Arma {

    public EspadaAperfeiçoada() {
        super("/com.daniel.Images/Armas/Espada aprimorada.png", "Espada Melhorada", 1, 200, "Concede aumento de 35 no ataque físico", 35, 0, TiposElementais.NaoElemental);
    }

    public EspadaAperfeiçoada(int quant) {
        super("/com.daniel.Images/Armas/Espada aprimorada.png", "Espada Melhorada", quant, 200, "Concede aumento de 35 no ataque físico", 35, 0, TiposElementais.NaoElemental);
    }
}
