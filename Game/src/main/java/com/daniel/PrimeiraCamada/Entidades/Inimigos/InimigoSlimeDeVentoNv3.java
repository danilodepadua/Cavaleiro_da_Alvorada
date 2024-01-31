package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Minerios.BarraFerro;
import com.daniel.PrimeiraCamada.Itens.Minerios.BarraFogo;
import com.daniel.PrimeiraCamada.Magias.AirBlast;
import com.daniel.PrimeiraCamada.Magias.Sopro;
import com.daniel.PrimeiraCamada.Magias.Vento;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeVentoNv3 extends Inimigo {
    public InimigoSlimeDeVentoNv3() {
        super("Slime de vento grande", "/com.daniel.Images/Inimigos/Slime Windiii.png", 19, 45, 35, 35, 60, 55, 45, TiposElementais.Vento, Comportamentos.padrao, 100, 5);
        this.absorcao = new TiposElementais[]{TiposElementais.Vento};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra};
        this.magias.add(new Vento());
        this.magias.add(new Sopro());
        this.magias.add(new AirBlast());
        this.lootTable.AdicionarEntrada(new BarraFogo(), 0, 2, 0.2);

    }
}
