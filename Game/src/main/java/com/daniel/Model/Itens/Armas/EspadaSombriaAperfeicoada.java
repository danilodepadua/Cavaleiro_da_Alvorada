package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class EspadaSombriaAperfeicoada extends Arma {
    public EspadaSombriaAperfeicoada() {
        super("/com.daniel.Images/Armas/w_sword_roman_dark.png", new TextoNode("Espada super sombria", "Improved Dark Sword"), 1, 1500, new TextoNode("Concede um aumento de 60 no ataque mágico", "Incrases magic attack by 60"), 0, 60, TiposElementais.Escuridao);
    }

    public EspadaSombriaAperfeicoada(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman_dark.png", new TextoNode("Espada super sombria", "Improved Dark Sword"), quant, 1500, new TextoNode("Concede um aumento de 60 no ataque mágico", "Incrases magic attack by 60"), 0, 60, TiposElementais.Escuridao);
    }
}
