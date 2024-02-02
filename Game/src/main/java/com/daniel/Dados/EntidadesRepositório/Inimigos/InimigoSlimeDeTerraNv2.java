package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Comidas.Banana;
import com.daniel.Modelo.Itens.Minerios.BarraFerro;
import com.daniel.Modelo.Magia.Poderes.Endurecer;
import com.daniel.Modelo.Magia.Poderes.Terra;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeTerraNv2 extends Inimigo {
    public InimigoSlimeDeTerraNv2() {
        super("Slime de terra médio", "/com.daniel.Images/Inimigos/Slime Earthii.png", 21, 25, 35, 45, 25, 105, 35, TiposElementais.Terra, Comportamentos.padrao, 250, 150);
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.resistencias = new TiposElementais[]{TiposElementais.Eletrico, TiposElementais.Vento};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua};
        this.magias.add(new Terra());
        this.magias.add(new Endurecer());
        this.lootTable.AdicionarEntrada(new Banana(), 1, 2, 0.3);
        this.lootTable.AdicionarEntrada(new BarraFerro(), 1, 2, 0.3);


    }
}
