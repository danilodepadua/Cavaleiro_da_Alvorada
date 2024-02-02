package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Comidas.Banana;
import com.daniel.Modelo.Itens.Minerios.Ferro;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoBabySlime extends Inimigo {
    public InimigoBabySlime() {
        super("Slime", "/com.daniel.Images/Inimigos/Slime Blue.png", 1, 5, 2, 10, 15, 10, 10, TiposElementais.NaoElemental, Comportamentos.padrao, 100, 15);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.lootTable.AdicionarEntrada(new Banana(), 1, 1, 0.2);
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 1, 0.6);
    }
}
