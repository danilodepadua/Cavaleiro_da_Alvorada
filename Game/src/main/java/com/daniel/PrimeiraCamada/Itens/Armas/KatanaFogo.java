package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class KatanaFogo extends Arma {
    public KatanaFogo() {
        super("/com.daniel.Images/Armas/w_katana_fire.png", "Katana de fogo", 1, 3000, "Concede aumento de 80 no ataque mágico", 0, 80, TiposElementais.Fogo);
    }

    public KatanaFogo(int quant) {
        super("/com.daniel.Images/Armas/w_katana_fire.png", "Katana de fogo", quant, 3000, "Concede aumento de 80 no ataque mágico", 0, 80, TiposElementais.Fogo);
    }
}
