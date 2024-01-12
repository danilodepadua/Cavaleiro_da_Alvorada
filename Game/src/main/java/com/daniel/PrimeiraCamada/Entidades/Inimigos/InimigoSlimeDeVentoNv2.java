package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeVentoNv2 extends Inimigo {
    public InimigoSlimeDeVentoNv2() {
        super("Slime de vento médio", "/com.daniel.Images/Inimigos/Slime Windii.png", 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao);
    }
}
