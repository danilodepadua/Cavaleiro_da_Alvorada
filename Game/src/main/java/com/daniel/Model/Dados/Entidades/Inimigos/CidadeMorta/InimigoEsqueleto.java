package com.daniel.Model.Dados.Entidades.Inimigos.CidadeMorta;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoEsqueleto extends Inimigo {
    public InimigoEsqueleto() {
        super("Bones", "/com.daniel.Images/Inimigos/Halloween Skeleton.png", 40, 5, 2, 10, 15, 15,65, 10, TiposElementais.NaoElemental, Comportamentos.padrao, 100, 15);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 1, 0.6);
    }
}
