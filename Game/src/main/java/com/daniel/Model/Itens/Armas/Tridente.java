package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class Tridente extends Arma {
    public Tridente() {
        super("/com.daniel.Images/Armas/w_trident.png", new TextoNode("Tridente","Trident"), 1, 3000, new TextoNode("Concede aumento de 90 no ataque físico", "Increases physical attack by 90"), 90, 0, TiposElementais.NaoElemental);
    }

    public Tridente(int quant) {
        super("/com.daniel.Images/Armas/w_trident.png", new TextoNode("Tridente","Trident"), quant, 3000, new TextoNode("Concede aumento de 90 no ataque físico", "Increases physical attack by 90"), 90, 0, TiposElementais.NaoElemental);
    }
}
