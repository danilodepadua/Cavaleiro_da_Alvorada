package com.daniel.Model.Dados.Itens.Armas;

import com.daniel.Model.Dados.Itens.Arma;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class KatanaGelo extends Arma {
    public KatanaGelo() {
        super("/com.daniel.Images/Armas/w_katana_diamond.png", "Katana Glacial", 1, 3500, "Concede aumento de 75 no ataque físico", 75, 0, TiposElementais.Gelo);
    }

    public KatanaGelo(int quant) {
        super("/com.daniel.Images/Armas/w_katana_diamond.png", "Katana Glacial", quant, 3500, "Concede aumento de 75 no ataque físico", 75, 0, TiposElementais.Gelo);
    }
}
