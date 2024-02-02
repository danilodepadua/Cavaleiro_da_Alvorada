package com.daniel.Model.Dados.Itens.Armas;

import com.daniel.Model.Dados.Itens.Arma;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class EspadaFogoBasica extends Arma {
    public EspadaFogoBasica() {
        super("/com.daniel.Images/Armas/Espada de fogo.png", "Espada de fogo", 1, 300, "Concede aumento de 20 no ataque mágico", 0, 20, TiposElementais.Fogo);
    }

    public EspadaFogoBasica(int quant) {
        super("/com.daniel.Images/Armas/Espada de fogo.png", "Espada de fogo", quant, 300, "Concede aumento de 20 no ataque mágico", 0, 20, TiposElementais.Fogo);
    }
}
