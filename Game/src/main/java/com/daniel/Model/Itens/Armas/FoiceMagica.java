package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class FoiceMagica extends Arma {

    public FoiceMagica() {
        super("/com.daniel.Images/Armas/FoiceMagica.png", new TextoNode("Foice Mágica", "Magical Scythe"), 1, 1000, new TextoNode("Concede aumento de 70 no ataque físico", "Increases physical attack by 70"), 70, 0, TiposElementais.Escuridao);
    }

    public FoiceMagica(int quant) {
        super("/com.daniel.Images/Armas/FoiceMagica.png", new TextoNode("Foice Mágica", "Magical Scythe"), quant, 1000, new TextoNode("Concede aumento de 70 no ataque físico", "Increases physical attack by 70"), 70, 0, TiposElementais.Escuridao);
    }
}
