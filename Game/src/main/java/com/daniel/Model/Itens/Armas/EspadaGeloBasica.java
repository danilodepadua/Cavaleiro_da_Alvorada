package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class EspadaGeloBasica extends Arma {
    public EspadaGeloBasica() {
        super("/com.daniel.Images/Armas/Espada de gelo.png", new TextoNode("Espada de gelo", "Ice Sword"), 1, 2000, new TextoNode("Concede um aumento de 27 no ataque mágico", "Incrases magic attack by 27"), 0, 27, TiposElementais.Gelo);
    }

    public EspadaGeloBasica(int quant) {
        super("/com.daniel.Images/Armas/Espada de gelo.png", new TextoNode("Espada de gelo", "Ice Sword"), quant, 2000, new TextoNode("Concede um aumento de 27 no ataque mágico", "Incrases magic attack by 27"), 0, 27, TiposElementais.Gelo);
    }
}
