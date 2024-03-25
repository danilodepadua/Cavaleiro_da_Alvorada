package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class EspadaEletricaBasica extends Arma {
    public EspadaEletricaBasica() {
        super("/com.daniel.Images/Armas/Espada eletrica.png", new TextoNode("Espada Elétrica", "Eletric Sword"), 1, 1900, new TextoNode("Concede um aumento de 25 no ataque mágico", "Incrases magic attack by 25"), 0, 25, TiposElementais.Eletrico);
    }

    public EspadaEletricaBasica(int quant) {
        super("/com.daniel.Images/Armas/Espada eletrica.png", new TextoNode("Espada Elétrica", "Eletric Sword"), quant, 1900, new TextoNode("Concede um aumento de 25 no ataque mágico", "Incrases magic attack by 25"), 0, 25, TiposElementais.Eletrico);
    }
}
