package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Endurecer;
import com.daniel.PrimeiraCamada.Magias.ParedeTerra;
import com.daniel.PrimeiraCamada.Magias.Terra;
import com.daniel.PrimeiraCamada.TiposElementais;

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
    }
}
