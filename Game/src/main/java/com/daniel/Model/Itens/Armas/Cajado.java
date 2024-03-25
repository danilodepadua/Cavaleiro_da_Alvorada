package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class Cajado extends Arma {
    public Cajado() {
        super("/com.daniel.Images/Itens/Cajado.png", new TextoNode("Cajado Mágico", "Magic Staff"), 1, 1000, new TextoNode("Concede um aumento de 10 no ataque mágico", "Incrases magic attack by 10"), 0, 10, TiposElementais.NaoElemental);
    }

    public Cajado(int quant) {
        super("/com.daniel.Images/Itens/Cajado.png", new TextoNode("Cajado Mágico", "Magic Staff"), quant, 10, new TextoNode("Concede um aumento de 10 no ataque mágico", "Incrases magic attack by 10"), 0, 10, TiposElementais.NaoElemental);
    }
}
