package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeRaioNv1 extends Inimigo {
    public InimigoSlimeDeRaioNv1() {
        super("Slime de raio pequeno", "/com.daniel.Images/Inimigos/Slime Thunderi.png", 14, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100);
    }
}
