package com.daniel.Model.Dados.Entidades.Inimigos;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigo;
import com.daniel.Model.Itens.Comidas.Banana;
import com.daniel.Model.Itens.Minerios.BarraFerro;
import com.daniel.Model.Magias.Poderes.Endurecer;
import com.daniel.Model.Magias.Poderes.Terra;
import com.daniel.Model.Magias.TiposElementais;

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
