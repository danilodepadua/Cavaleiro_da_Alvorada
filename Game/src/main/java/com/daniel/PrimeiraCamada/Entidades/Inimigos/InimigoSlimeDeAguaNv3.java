package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeAguaNv3 extends Inimigo {
    public InimigoSlimeDeAguaNv3() {
        super("Slime de água grande", "/com.daniel.Images/Inimigos/Slime Wateriii.png", 13, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100);
    }
}
