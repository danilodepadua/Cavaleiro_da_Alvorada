package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaAperfeiçoada extends Arma {

    public EspadaAperfeiçoada() {
        super("/com.daniel.Images/Armas/Espada aprimorada.png", "Espada Melhorada", 1, 55, "Concede aumento de 65 no ataque físico", 65, 0, TiposElementais.NaoElemental);
    }

    public EspadaAperfeiçoada(int quant) {
        super("/com.daniel.Images/Armas/Espada aprimorada.png", "Espada Melhorada", quant, 55, "Concede aumento de 65 no ataque físico", 65, 0, TiposElementais.NaoElemental);
    }
}
