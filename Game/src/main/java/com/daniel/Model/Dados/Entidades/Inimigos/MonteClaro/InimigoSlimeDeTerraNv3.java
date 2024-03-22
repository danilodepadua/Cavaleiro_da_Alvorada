package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.BarraOuro;
import com.daniel.Model.Magias.Poderes.Endurecer;
import com.daniel.Model.Magias.Poderes.ParedeTerra;
import com.daniel.Model.Magias.Poderes.Terra;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeTerraNv3 extends Inimigo {
    public InimigoSlimeDeTerraNv3() {
        super("Slime de terra grande", "/com.daniel.Images/Inimigos/Slime Earthiii.png", 18, 30, 20, 38, 20,  27,5000, 85, TiposElementais.Terra, Comportamentos.padrao, 2000, 1000);
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.resistencias = new TiposElementais[]{TiposElementais.Eletrico, TiposElementais.Vento};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua};
        this.magias.add(new Terra());
        this.magias.add(new ParedeTerra());
        this.magias.add(new Endurecer());
        this.lootTable.AdicionarEntrada(new BarraOuro(), 1, 2, 0.3);
    }
}
