package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Minerios.BarraFogo;
import com.daniel.Modelo.Magia.Poderes.AirBlast;
import com.daniel.Modelo.Magia.Poderes.Sopro;
import com.daniel.Modelo.Magia.Poderes.Vento;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeVentoNv3 extends Inimigo {
    public InimigoSlimeDeVentoNv3() {
        super("Slime de vento grande", "/com.daniel.Images/Inimigos/Slime Windiii.png", 19, 45, 35, 35, 60, 55, 45, TiposElementais.Vento, Comportamentos.padrao, 100, 5);
        this.absorcao = new TiposElementais[]{TiposElementais.Vento};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra};
        this.magias.add(new Vento());
        this.magias.add(new Sopro());
        this.magias.add(new AirBlast());
        this.lootTable.AdicionarEntrada(new BarraFogo(), 1, 2, 0.2);

    }
}
