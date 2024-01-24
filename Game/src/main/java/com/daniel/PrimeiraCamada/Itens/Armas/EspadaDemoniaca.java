package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class EspadaDemoniaca extends Arma {
    public EspadaDemoniaca() {
        super("/com.daniel.Images/Armas/w_sword_roman_blood.png", "Espada Destruidora", 1, 200, "Concede aumento de 50 no ataque mágico", 0, 50, TiposElementais.Fogo);
    }

    public EspadaDemoniaca(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman_blood.png", "Espada Destruidora", quant, 200, "Concede aumento de 50 no ataque mágico", 0, 50, TiposElementais.Fogo);
    }
}
