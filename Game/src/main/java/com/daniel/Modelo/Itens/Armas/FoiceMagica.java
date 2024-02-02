package com.daniel.Modelo.Itens.Armas;

import com.daniel.Modelo.Itens.Arma;
import com.daniel.Modelo.Magia.TiposElementais;

public class FoiceMagica extends Arma {

    public FoiceMagica() {
        super("/com.daniel.Images/Armas/FoiceMagica.png", "Foice Mágica", 1, 1000, "Concede aumento de 70 no ataque físico", 70, 0, TiposElementais.Escuridao);
    }

    public FoiceMagica(int quant) {
        super("/com.daniel.Images/Armas/FoiceMagica.png", "Foice Mágica", quant, 1000, "Concede aumento de 70 no ataque físico", 70, 0, TiposElementais.Escuridao);
    }
}
