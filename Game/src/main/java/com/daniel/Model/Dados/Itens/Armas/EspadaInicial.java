package com.daniel.Model.Dados.Itens.Armas;

import com.daniel.Model.Dados.Itens.Arma;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class EspadaInicial extends Arma {
    public EspadaInicial() {
        super("/com.daniel.Images/Armas/Espada basica.png", "Espada básica", 1, 100, "Concede aumento de 15 no ataque físico", 15, 0, TiposElementais.NaoElemental);
    }

    public EspadaInicial(int quant) {
        super("/com.daniel.Images/Armas/Espada basica.png", "Espada básica", quant, 100, "Concede aumento de 15 no ataque físico", 15, 0, TiposElementais.NaoElemental);
    }
}
