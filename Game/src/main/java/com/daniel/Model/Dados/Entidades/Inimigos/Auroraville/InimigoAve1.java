package com.daniel.Model.Dados.Entidades.Inimigos.Auroraville;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Magias.Poderes.Vento;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoAve1 extends Inimigo {
    public InimigoAve1() {
        super("Silver Avian", "/com.daniel.Images/Inimigos/Megapack II Silver Avian.png", 3, 15, 18, 15, 20, 17,2000, 110, TiposElementais.NaoElemental, Comportamentos.padrao, 400, 200);
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra};
        this.resistencias = new TiposElementais[]{TiposElementais.Vento};
        this.magias.add(new Vento());
        this.lootTable.AdicionarEntrada(new PocaoCura(), 0, 2, 0.45);
    }
}
