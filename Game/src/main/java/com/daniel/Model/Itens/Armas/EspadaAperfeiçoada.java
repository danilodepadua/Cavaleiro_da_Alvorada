package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class EspadaAperfeiçoada extends Arma {

    public EspadaAperfeiçoada() {
        super("/com.daniel.Images/Armas/w_sword_roman.png", new TextoNode("Espada Melhorada", "Improved Sword"), 1, 200, new TextoNode("Concede aumento de 35 no ataque físico", "Increases physical attack by 35"), 35, 0, TiposElementais.NaoElemental);
    }

    public EspadaAperfeiçoada(int quant) {
        super("/com.daniel.Images/Armas/w_sword_roman.png", new TextoNode("Espada Melhorada", "Improved Sword"), quant, 200, new TextoNode("Concede aumento de 35 no ataque físico", "Increases physical attack by 35"), 35, 0, TiposElementais.NaoElemental);
    }
}
