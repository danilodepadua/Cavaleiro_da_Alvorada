package com.daniel.Model.Dados.Entidades.Inimigos.Auroraville;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoBabySlime extends Inimigo {
    public InimigoBabySlime() {
        super("Slime", "/com.daniel.Images/Inimigos/Slime Blue.png", 1, 16, 16, 16, 16, 16,1000, 60, TiposElementais.NaoElemental, Comportamentos.padrao, 200, 100);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.lootTable.AdicionarEntrada(new PocaoCura(), 0, 1, 0.4);
    }
}
