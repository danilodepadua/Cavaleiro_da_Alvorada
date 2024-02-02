package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Minerios.BarraFerro;
import com.daniel.Modelo.Magia.Poderes.Sopro;
import com.daniel.Modelo.Magia.Poderes.Vento;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeVentoNv2 extends Inimigo {
    public InimigoSlimeDeVentoNv2() {
        super("Slime de vento médio", "/com.daniel.Images/Inimigos/Slime Windii.png", 18, 35, 25, 25, 50, 45, 35, TiposElementais.Vento, Comportamentos.padrao, 100, 5);
        this.absorcao = new TiposElementais[]{TiposElementais.Vento};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra};
        this.magias.add(new Vento());
        this.magias.add(new Sopro());
        this.lootTable.AdicionarEntrada(new BarraFerro(), 1, 2, 0.2);

    }
}
