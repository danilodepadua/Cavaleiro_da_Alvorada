package com.daniel.Model.Dados.Entidades.Inimigos.Desapoles;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.BarraFogo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Itens.Pocoes.TonicoDeVelocidade;
import com.daniel.Model.Magias.Poderes.AirBlast;
import com.daniel.Model.Magias.Poderes.Sopro;
import com.daniel.Model.Magias.Poderes.Vento;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeVentoNv3 extends Inimigo {
    public InimigoSlimeDeVentoNv3() {
        super("Slime de vento grande", "/com.daniel.Images/Inimigos/Slime Windiii.png", 9, 22, 22, 22, 22, 22,4500, 100, TiposElementais.Vento, Comportamentos.padrao, 1000, 500);
        this.absorcao = new TiposElementais[]{TiposElementais.Vento};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra};
        this.magias.add(new Vento());
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 2, 0.2);
        this.lootTable.AdicionarEntrada(new FragVel(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new PocaoCura(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new TonicoDeVelocidade(), 0, 1, 0.05);
    }
}
