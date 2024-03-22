package com.daniel.Model.Dados.Entidades.Inimigos.Auroraville;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Magias.Poderes.AirBlast;
import com.daniel.Model.Magias.Poderes.Vento;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoAve2 extends Inimigo {
    public InimigoAve2() {
        super("Razortail Eagle", "/com.daniel.Images/Inimigos/Megapack II Mountain Razortail Eagle.png", 4, 18, 19, 17, 22, 18,4000, 150, TiposElementais.NaoElemental, Comportamentos.padrao, 600, 300);
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra};
        this.resistencias = new TiposElementais[]{TiposElementais.Vento};
        this.magias.add(new Vento());
        this.magias.add(new AirBlast());
        this.lootTable.AdicionarEntrada(new PocaoCura(), 0, 2, 0.5);
    }
}
