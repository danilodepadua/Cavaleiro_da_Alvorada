package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.ComportamentosInimigos.ComportamentoPadrao;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Comidas.Banana;
import com.daniel.PrimeiraCamada.Itens.Comidas.CoxaFrango;
import com.daniel.PrimeiraCamada.Itens.Minerios.BarraFerro;
import com.daniel.PrimeiraCamada.Itens.Minerios.Ferro;
import com.daniel.PrimeiraCamada.Magias.Splash;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeAguaNv1 extends Inimigo {
    public InimigoSlimeDeAguaNv1() {
        super("Slime de água pequeno", "/com.daniel.Images/Inimigos/Slime Wateri.png", 11, 20, 15, 15, 25, 35, 50, TiposElementais.Agua, Comportamentos.padrao, 250, 150);
        this.magias.add(new Splash());
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
