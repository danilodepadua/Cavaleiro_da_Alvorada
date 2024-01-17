package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeTerraNv1 extends Inimigo {
    public InimigoSlimeDeTerraNv1() {
        super("Slime de terra pequeno", "/com.daniel.Images/Inimigos/Slime Earthi.png", 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100);
    }
}
