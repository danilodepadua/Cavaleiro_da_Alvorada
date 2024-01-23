package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeGeloNv2 extends Inimigo {
    public InimigoSlimeDeGeloNv2() {
        super("Slime de gelo médio", "/com.daniel.Images/Inimigos/Slime Iceii.png", 9, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100, 5);
    }
}
