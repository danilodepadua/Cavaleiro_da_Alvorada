package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class EspadaLuz extends Arma {
    public EspadaLuz() {
        super("/com.daniel.Images/Armas/w_sword_roman_lightning.png", new TextoNode("Espada da Luz", "Holy Sword"), 1, 50000, new TextoNode("Concede aumento de 100 no ataque físico e mágico", "Increases physical and magic attack by 100"), 100, 100, TiposElementais.Luz);
    }

    public EspadaLuz(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman_lightning.png", new TextoNode("Espada da Luz", "Holy Sword"), quant, 50000, new TextoNode("Concede aumento de 100 no ataque físico e mágico", "Increases physical and magic attack by 100"), 100, 100, TiposElementais.Luz);
    }
}
