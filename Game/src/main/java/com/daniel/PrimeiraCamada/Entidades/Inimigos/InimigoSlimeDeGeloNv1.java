package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Gelo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeGeloNv1 extends Inimigo {
    public InimigoSlimeDeGeloNv1() {
        super("Slime de gelo pequeno", "/com.daniel.Images/Inimigos/Slime Icei.png", 8, 20, 15, 25, 25, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 150, 50);
        this.magias.add(new Gelo());
        this.absorcao = new TiposElementais[]{TiposElementais.Gelo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.resistencias = new TiposElementais[]{TiposElementais.Agua};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
