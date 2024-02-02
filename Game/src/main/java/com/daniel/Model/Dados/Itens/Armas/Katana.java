package com.daniel.Model.Dados.Itens.Armas;

import com.daniel.Model.Dados.Itens.Arma;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Katana extends Arma {
    public Katana() {
        super("/com.daniel.Images/Armas/w_katana.png", "Katana", 1, 800, "Concede aumento de 50 no ataque físico", 50, 0, TiposElementais.NaoElemental);
    }

    public Katana(int quant) {
        super("/com.daniel.Images/Armas/w_katana.png", "Katana", quant, 800, "Concede aumento de 50 no ataque físico", 50, 0, TiposElementais.NaoElemental);
    }
}
