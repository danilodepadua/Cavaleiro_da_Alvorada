package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeGeloNv1 extends Inimigo {
    public InimigoSlimeDeGeloNv1() {
        super("Slime de gelo pequeno", "/com.daniel.Images/Inimigos/Slime Icei.png", 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100);
    }
}
