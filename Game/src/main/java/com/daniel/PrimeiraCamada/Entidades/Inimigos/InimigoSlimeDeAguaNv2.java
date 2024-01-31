package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Comidas.Banana;
import com.daniel.PrimeiraCamada.Itens.Comidas.CoxaFrango;
import com.daniel.PrimeiraCamada.Itens.Minerios.BarraFerro;
import com.daniel.PrimeiraCamada.Itens.Minerios.Ferro;
import com.daniel.PrimeiraCamada.Itens.Minerios.FragmentoFogo;
import com.daniel.PrimeiraCamada.Itens.Minerios.FragmentoGlacial;
import com.daniel.PrimeiraCamada.Magias.Splash;
import com.daniel.PrimeiraCamada.Magias.WaterSpyke;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeAguaNv2 extends Inimigo {
    public InimigoSlimeDeAguaNv2() {
        super("Slime de água médio", "/com.daniel.Images/Inimigos/Slime Waterii.png", 12, 30, 25, 25, 35,  75, 70, TiposElementais.Agua, Comportamentos.padrao, 350, 250);
        this.magias.add(new Splash());
        this.magias.add(new WaterSpyke());
        this.resistencias = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{ TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.absorcao = new TiposElementais[]{TiposElementais.Agua};
        this.lootTable.AdicionarEntrada(new FragmentoGlacial(), 0, 1, 0.5);

    }
}
