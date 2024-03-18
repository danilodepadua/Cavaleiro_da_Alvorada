package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class EspadaSombriaBasica extends Arma {
    public EspadaSombriaBasica() {
        super("/com.daniel.Images/Armas/Espada Sombria.png", new TextoNode("Espada Sombria", "Dark Sword"), 1, 1100, new TextoNode("Concede um aumento de 30 no ataque mágico", "Incrases magic attack by 30"), 0, 30, TiposElementais.Escuridao);
    }

    public EspadaSombriaBasica(int quant) {
        super("/com.daniel.Images/Armas/Espada Sombria.png", new TextoNode("Espada Sombria", "Dark Sword"), quant, 1100, new TextoNode("Concede um aumento de 30 no ataque mágico", "Incrases magic attack by 30"), 0, 30, TiposElementais.Escuridao);
    }
}

