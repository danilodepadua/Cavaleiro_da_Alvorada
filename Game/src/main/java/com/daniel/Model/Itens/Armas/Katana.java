package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class Katana extends Arma {
    public Katana() {
        super("/com.daniel.Images/Armas/w_katana.png", new TextoNode("Katana", "Katana"), 1, 3500, new TextoNode("Concede aumento de 50 no ataque físico", "Increases physical attack by 50"), 50, 0, TiposElementais.NaoElemental);
    }

    public Katana(int quant) {
        super("/com.daniel.Images/Armas/w_katana.png", new TextoNode("Katana", "Katana"), quant, 3500, new TextoNode("Concede aumento de 50 no ataque físico", "Increases physical attack by 50"), 50, 0, TiposElementais.NaoElemental);
    }
}
