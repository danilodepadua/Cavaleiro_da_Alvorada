package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class EspadaInicial extends Arma {
    public EspadaInicial() {
        super("/com.daniel.Images/Armas/Espada basica.png", new TextoNode("Espada básica", "Basic Sword"), 1, 1000, new TextoNode("Concede aumento de 15 no ataque físico", "Increases physical attack by 15"), 15, 0, TiposElementais.NaoElemental);
    }

    public EspadaInicial(int quant) {
        super("/com.daniel.Images/Armas/Espada basica.png", new TextoNode("Espada básica", "Basic Sword"), quant, 1000, new TextoNode("Concede aumento de 15 no ataque físico", "Increases physical attack by 15"), 15, 0, TiposElementais.NaoElemental);
    }
}
