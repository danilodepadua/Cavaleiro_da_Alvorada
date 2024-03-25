package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class KatanaGelo extends Arma {
    public KatanaGelo() {
        super("/com.daniel.Images/Armas/w_katana_diamond.png", new TextoNode("Katana Glacial","Ice Katana"), 1, 35000, new TextoNode("Concede aumento de 75 no ataque físico e mágico", "Increases physical and magic attack by 75"), 75, 0, TiposElementais.Gelo);
    }

    public KatanaGelo(int quant) {
        super("/com.daniel.Images/Armas/w_katana_diamond.png", new TextoNode("Katana Glacial","Ice Katana"), quant, 35000, new TextoNode("Concede aumento de 75 no ataque físico e mágico", "Increases physical and magic attack by 75"), 75, 75, TiposElementais.Gelo);
    }
}
