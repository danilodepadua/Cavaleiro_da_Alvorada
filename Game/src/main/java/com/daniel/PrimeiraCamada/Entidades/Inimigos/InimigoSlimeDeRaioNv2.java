package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeRaioNv2 extends Inimigo {
    public InimigoSlimeDeRaioNv2() {
        super("Slime de raio médio", "/com.daniel.Images/Inimigos/Slime Thunderii.png", 15, 5, 5, 5, 5,  5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100, 5);
    }
}
