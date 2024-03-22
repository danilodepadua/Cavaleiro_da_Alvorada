package com.daniel.Model.Dados.Entidades.Inimigos.Auroraville;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeNv3 extends Inimigo {
    public InimigoSlimeNv3() {
        super("Slime grande", "/com.daniel.Images/Inimigos/slimeiii.png", 2, 18, 15, 18, 18, 16,2000, 120, TiposElementais.NaoElemental, Comportamentos.padrao, 400, 200);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.lootTable.AdicionarEntrada(new PocaoCura(), 0, 1, 0.4);
        this.lootTable.AdicionarEntrada(new PocaoMp(), 0, 1, 0.4);
    }
}
