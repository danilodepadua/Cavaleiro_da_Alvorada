package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Dados.Itens.Comidas.Banana;
import com.daniel.Model.Dados.Itens.Minerios.BarraOuro;
import com.daniel.Model.Dados.Magias.Poderes.Endurecer;
import com.daniel.Model.Dados.Magias.Poderes.ParedeTerra;
import com.daniel.Model.Dados.Magias.Poderes.Terra;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class InimigoSlimeDeTerraNv3 extends Inimigo {
    public InimigoSlimeDeTerraNv3() {
        super("Slime de terra grande", "/com.daniel.Images/Inimigos/Slime Earthiii.png", 22, 35, 40, 60, 35,  150, 45, TiposElementais.Terra, Comportamentos.padrao, 400, 250);
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.resistencias = new TiposElementais[]{TiposElementais.Eletrico, TiposElementais.Vento};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua};
        this.magias.add(new Terra());
        this.magias.add(new ParedeTerra());
        this.magias.add(new Endurecer());
        this.lootTable.AdicionarEntrada(new Banana(), 1, 2, 0.3);
        this.lootTable.AdicionarEntrada(new BarraOuro(), 1, 2, 0.3);
    }
}
