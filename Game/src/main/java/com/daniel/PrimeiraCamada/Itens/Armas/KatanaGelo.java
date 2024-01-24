package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class KatanaGelo extends Arma {
    public KatanaGelo() {
        super("/com.daniel.Images/Armas/w_katana_diamond.png", "Katana Glacial", 1, 130, "Concede aumento de 75 no ataque físico", 75, 0, TiposElementais.Gelo);
    }

    public KatanaGelo(int quant) {
        super("/com.daniel.Images/Armas/w_katana_diamond.png", "Katana Glacial", quant, 130, "Concede aumento de 75 no ataque físico", 75, 0, TiposElementais.Gelo);
    }
}
