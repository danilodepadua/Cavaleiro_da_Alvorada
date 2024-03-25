package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.BarraOuro;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragResM;
import com.daniel.Model.Itens.Minerios.FragP.FragRes;
import com.daniel.Model.Itens.Pocoes.TonicoDeResistencia;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeTerraNv3 extends Inimigo {
    public InimigoSlimeDeTerraNv3() {
        super("Slime de terra grande", "/com.daniel.Images/Inimigos/Slime Earthiii.png", 18, 30, 20, 38, 20,  27,5000, 85, TiposElementais.Terra, Comportamentos.padrao, 2000, 1000);
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua};
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Terra());
        this.magias.add(new Endurecer());
        this.lootTable.AdicionarEntrada(new FragRes(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new FragResM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 3, 0.7);
        this.lootTable.AdicionarEntrada(new TonicoDeResistencia(), 0, 3, 0.1);
    }
}
