package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class EspadaDemoniaca extends Arma {
    public EspadaDemoniaca() {
        super("/com.daniel.Images/Armas/EspadaFogoAprimorada.png", new TextoNode("Espada Demoníaca","Demonic Sword"), 1, 19000, new TextoNode("Concede um aumento de 40 no ataque mágico", "Incrases magic attack by 40"), 0, 40, TiposElementais.Fogo);
    }

    public EspadaDemoniaca(int quant) {
        super("/com.daniel.Images/Armas/EspadaFogoAprimorada.png", new TextoNode("Espada Demoníaca","Demonic Sword"), quant, 19000, new TextoNode("Concede um aumento de 40 no ataque mágico", "Incrases magic attack by 40"), 0, 40, TiposElementais.Fogo);
    }
}
