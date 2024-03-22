package com.daniel.Model.Dados.Entidades.Inimigos.CidadeMorta;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSangueSuga extends Inimigo {
    public InimigoSangueSuga() {
        super("Chup-Chup", "/com.daniel.Images/Inimigos/Vampiric Creature Dragon Lamprey.png", 45, 5, 2, 10, 15, 15,65, 10, TiposElementais.NaoElemental, Comportamentos.padrao, 100, 15);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 1, 0.6);
    }
}
