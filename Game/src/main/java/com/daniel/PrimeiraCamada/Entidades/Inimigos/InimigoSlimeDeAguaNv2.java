package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeAguaNv2 extends Inimigo {
    public InimigoSlimeDeAguaNv2() {
        super("Slime de água médio", "/com.daniel.Images/Inimigos/Slime Waterii.png", 12, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100);
    }
}
