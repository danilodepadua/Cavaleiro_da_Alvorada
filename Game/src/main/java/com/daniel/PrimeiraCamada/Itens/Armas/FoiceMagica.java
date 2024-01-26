package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class FoiceMagica extends Arma {

    public FoiceMagica() {
        super("/com.daniel.Images/Armas/FoiceMagica.png", "Foice Mágica", 1, 60, "Concede aumento de 90 no ataque físico", 90, 25, TiposElementais.Escuridao);
    }

    public FoiceMagica(int quant) {
        super("/com.daniel.Images/Armas/FoiceMagica.png", "Foice Mágica", quant, 60, "Concede aumento de 90 no ataque físico", 90, 25, TiposElementais.Escuridao);
    }
}
