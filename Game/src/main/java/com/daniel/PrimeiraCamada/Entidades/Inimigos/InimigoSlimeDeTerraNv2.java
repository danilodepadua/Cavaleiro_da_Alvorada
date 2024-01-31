package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Comidas.Banana;
import com.daniel.PrimeiraCamada.Itens.Minerios.BarraFerro;
import com.daniel.PrimeiraCamada.Magias.Endurecer;
import com.daniel.PrimeiraCamada.Magias.ParedeTerra;
import com.daniel.PrimeiraCamada.Magias.Terra;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeTerraNv2 extends Inimigo {
    public InimigoSlimeDeTerraNv2() {
        super("Slime de terra médio", "/com.daniel.Images/Inimigos/Slime Earthii.png", 21, 25, 35, 45, 25, 105, 35, TiposElementais.Terra, Comportamentos.padrao, 250, 150);
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.resistencias = new TiposElementais[]{TiposElementais.Eletrico, TiposElementais.Vento};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua};
        this.magias.add(new Terra());
        this.magias.add(new Endurecer());
        this.lootTable.AdicionarEntrada(new Banana(), 0, 2, 0.3);
        this.lootTable.AdicionarEntrada(new BarraFerro(), 0, 2, 0.3);


    }
}
