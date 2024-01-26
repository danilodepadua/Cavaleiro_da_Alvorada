package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class ManoplaTita extends Arma {

    public ManoplaTita() {
        super("/com.daniel.Images/Armas/ManoplaDeTita.png", "Manopla de Titã", 1, 999, "Concede aumento infinito no ataque físico", 999, 999, TiposElementais.Escuridao);
    }

    public ManoplaTita(int quant) {
        super("/com.daniel.Images/Armas/ManoplaDeTita.png", "Manopla de Titã", quant, 999, "Concede aumento infinito no ataque físico", 999, 999, TiposElementais.Escuridao);
    }
}
