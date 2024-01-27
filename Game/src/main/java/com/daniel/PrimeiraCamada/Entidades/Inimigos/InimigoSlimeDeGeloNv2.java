package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Gelo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeGeloNv2 extends Inimigo {
    public InimigoSlimeDeGeloNv2() {
        super("Slime de gelo médio", "/com.daniel.Images/Inimigos/Slime Iceii.png", 9, 30, 25, 35, 30, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 250, 75);
        this.magias.add(new Gelo());
        this.absorcao = new TiposElementais[]{TiposElementais.Gelo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.resistencias = new TiposElementais[]{TiposElementais.Agua};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
