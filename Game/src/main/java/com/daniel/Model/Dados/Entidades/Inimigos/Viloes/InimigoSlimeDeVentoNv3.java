package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Dados.Itens.Minerios.BarraFogo;
import com.daniel.Model.Dados.Magias.Poderes.AirBlast;
import com.daniel.Model.Dados.Magias.Poderes.Sopro;
import com.daniel.Model.Dados.Magias.Poderes.Vento;
import com.daniel.Model.Dados.Magias.TiposElementais;

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
