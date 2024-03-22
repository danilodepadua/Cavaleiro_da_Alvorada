package com.daniel.Model.Dados.Entidades.Inimigos.Auroraville;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Magias.Poderes.AirBlast;
import com.daniel.Model.Magias.Poderes.Vento;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoAve3 extends Inimigo {
    public InimigoAve3() {
        super("Blue Seeker", "/com.daniel.Images/Inimigos/Megapack II Blue Seeker.png", 5, 23, 22, 19, 25, 21,4000, 200, TiposElementais.NaoElemental, Comportamentos.padrao, 800, 400);
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra};
        this.resistencias = new TiposElementais[]{TiposElementais.Vento};
        this.magias.add(new Vento());
        this.magias.add(new AirBlast());
        this.lootTable.AdicionarEntrada(new PocaoCura(), 0, 3, 0.6);
    }
}
