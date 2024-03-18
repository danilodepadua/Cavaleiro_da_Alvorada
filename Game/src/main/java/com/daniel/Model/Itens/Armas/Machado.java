package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class Machado extends Arma {

    public Machado() {
        super("/com.daniel.Images/Armas/machado.png", new TextoNode("Machado", "Axe"), 1, 40, new TextoNode("Concede aumento de 35 no ataque físico", "Increases physical attack by 35"), 35, 0, TiposElementais.NaoElemental);
    }

    public Machado(int quant) {
        super("/com.daniel.Images/Armas/machado.png", new TextoNode("Machado", "Axe"), quant, 40, new TextoNode("Concede aumento de 35 no ataque físico", "Increases physical attack by 35"), 35, 0, TiposElementais.NaoElemental);
    }
}
