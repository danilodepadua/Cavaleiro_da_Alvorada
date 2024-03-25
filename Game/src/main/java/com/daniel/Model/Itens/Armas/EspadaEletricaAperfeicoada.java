package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class EspadaEletricaAperfeicoada extends Arma {
    public EspadaEletricaAperfeicoada() {
        super("/com.daniel.Images/Armas/w_sword_roman_holly.png", new TextoNode("Espada super elétrica","Improved Eletric Sword"), 1, 20000, new TextoNode("Concede um aumento de 50 no ataque mágico", "Incrases magic attack by 50"), 0, 50, TiposElementais.Eletrico);
    }

    public EspadaEletricaAperfeicoada(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman_holly.png", new TextoNode("Espada super elétrica","Improved Eletric Sword"), quant, 20000, new TextoNode("Concede um aumento de 50 no ataque mágico", "Incrases magic attack by 50"), 0, 50, TiposElementais.Eletrico);
    }
}
