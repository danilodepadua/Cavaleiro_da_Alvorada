package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeGeloNv3 extends Inimigo {
    public InimigoSlimeDeGeloNv3() {
        super("Slime de gelo grande", "/com.daniel.Images/Inimigos/Slime Iceiii.png", 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao);
    }
}
