package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class KatanaFogo extends Arma {
    public KatanaFogo() {
        super("/com.daniel.Images/Armas/w_katana_fire.png", "Katana de fogo", 1, 150, "Concede aumento de 80 no ataque físico", 80, 0, TiposElementais.Fogo);
    }

    public KatanaFogo(int quant) {
        super("/com.daniel.Images/Armas/w_katana_fire.png", "Katana de fogo", quant, 150, "Concede aumento de 80 no ataque físico", 80, 0, TiposElementais.Fogo);
    }
}
