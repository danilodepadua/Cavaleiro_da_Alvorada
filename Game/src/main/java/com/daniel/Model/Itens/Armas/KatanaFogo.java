package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class KatanaFogo extends Arma {
    public KatanaFogo() {
        super("/com.daniel.Images/Armas/w_katana_fire.png", new TextoNode("Katana de fogo", "Fire Katana"), 1, 30000, new TextoNode("Concede um aumento de 80 no ataque mágico e físico", "Incrases magic and physical attack by 80"), 80, 80, TiposElementais.Fogo);
    }

    public KatanaFogo(int quant) {
        super("/com.daniel.Images/Armas/w_katana_fire.png", new TextoNode("Katana de fogo", "Fire Katana"), quant, 30000, new TextoNode("Concede um aumento de 80 no ataque mágico e físico", "Incrases magic and physical attack by 80"), 80, 80, TiposElementais.Fogo);
    }
}
