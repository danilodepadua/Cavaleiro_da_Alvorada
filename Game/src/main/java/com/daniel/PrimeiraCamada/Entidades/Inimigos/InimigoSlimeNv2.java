package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeNv2 extends Inimigo {
    public InimigoSlimeNv2() {
        super("Slime médio", "/com.daniel.Images/Inimigos/slimeii.png", 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100);
    }
}
