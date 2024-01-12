package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeTerraNv2 extends Inimigo {
    public InimigoSlimeDeTerraNv2() {
        super("Slime de terra médio", "/com.daniel.Images/Inimigos/Slime Earthii.png", 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao);
    }
}
