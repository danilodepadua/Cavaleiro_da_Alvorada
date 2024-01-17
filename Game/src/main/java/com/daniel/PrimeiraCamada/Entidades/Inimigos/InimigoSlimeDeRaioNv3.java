package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeRaioNv3 extends Inimigo {
    public InimigoSlimeDeRaioNv3() {
        super("Slime de raio grande", "/com.daniel.Images/Inimigos/Slime Thunderiii.png", 16, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100);
    }
}
