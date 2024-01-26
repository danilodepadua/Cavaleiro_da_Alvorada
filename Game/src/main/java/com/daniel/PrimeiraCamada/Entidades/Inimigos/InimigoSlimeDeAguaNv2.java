package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Splash;
import com.daniel.PrimeiraCamada.Magias.WaterSpyke;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeAguaNv2 extends Inimigo {
    public InimigoSlimeDeAguaNv2() {
        super("Slime de água médio", "/com.daniel.Images/Inimigos/Slime Waterii.png", 12, 30, 25, 25, 35,  50, 70, TiposElementais.Agua, Comportamentos.padrao, 250, 75);
        this.magias.add(new Splash());
        this.magias.add(new WaterSpyke());
        this.resistencias = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{ TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico, TiposElementais.Fogo};
        this.absorcao = new TiposElementais[]{TiposElementais.Agua};
        this.lootTable.AdicionarEntrada(new CoxaFrango(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new Banana(), 1, 2, 0.2);
        this.lootTable.AdicionarEntrada(new BarraFerro(), 1, 2, 0.1);
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 2, 0.8);
    }
}
