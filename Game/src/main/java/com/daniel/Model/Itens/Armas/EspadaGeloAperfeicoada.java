package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class EspadaGeloAperfeicoada extends Arma {
    public EspadaGeloAperfeicoada() {
        super("/com.daniel.Images/Armas/w_sword_roman_diamond.png", new TextoNode("Espada glacial", "Improved Ice Sword"), 1, 20500, new TextoNode("Concede um aumento de 60 no ataque mágico", "Incrases magic attack by 60"), 0, 60, TiposElementais.Gelo);
    }

    public EspadaGeloAperfeicoada(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman_diamond.png", new TextoNode("Espada glacial", "Improved Ice Sword"), quant, 20500, new TextoNode("Concede um aumento de 60 no ataque mágico", "Incrases magic attack by 60"), 0, 60, TiposElementais.Gelo);
    }
}
