package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class FoiceMagica extends Arma {

    public FoiceMagica() {
        super("/com.daniel.Images/Armas/FoiceMagica.png", "Foice Mágica", 1, 1000, "Concede aumento de 70 no ataque físico", 70, 0, TiposElementais.Escuridao);
    }

    public FoiceMagica(int quant) {
        super("/com.daniel.Images/Armas/FoiceMagica.png", "Foice Mágica", quant, 1000, "Concede aumento de 70 no ataque físico", 70, 0, TiposElementais.Escuridao);
    }
}
