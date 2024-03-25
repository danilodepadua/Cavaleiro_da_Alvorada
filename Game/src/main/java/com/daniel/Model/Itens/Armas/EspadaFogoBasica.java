package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class EspadaFogoBasica extends Arma {
    public EspadaFogoBasica() {
        super("/com.daniel.Images/Armas/Espada de fogo.png", new TextoNode("Espada de fogo","Fire Sword"), 1, 1800, new TextoNode("Concede um aumento de 20 no ataque mágico", "Incrases magic attack by 20"), 0, 20, TiposElementais.Fogo);
    }

    public EspadaFogoBasica(int quant) {
        super("/com.daniel.Images/Armas/Espada de fogo.png", new TextoNode("Espada de fogo","Fire Sword"), quant, 1800, new TextoNode("Concede um aumento de 20 no ataque mágico", "Incrases magic attack by 20"), 0, 20, TiposElementais.Fogo);
    }
}
