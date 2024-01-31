package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class Katana extends Arma {
    public Katana() {
        super("/com.daniel.Images/Armas/w_katana.png", "Katana", 1, 800, "Concede aumento de 50 no ataque físico", 50, 0, TiposElementais.NaoElemental);
    }

    public Katana(int quant) {
        super("/com.daniel.Images/Armas/w_katana.png", "Katana", quant, 800, "Concede aumento de 50 no ataque físico", 50, 0, TiposElementais.NaoElemental);
    }
}
