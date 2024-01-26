package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeNv2 extends Inimigo {
    public InimigoSlimeNv2() {
        super("Slime médio", "/com.daniel.Images/Inimigos/slimeii.png", 3, 20, 15, 18, 25, 20, 20, TiposElementais.Gelo, Comportamentos.padrao, 150, 25);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
