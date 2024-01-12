package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeFogoNv2 extends Inimigo {
    public InimigoSlimeDeFogoNv2() {
        super("Slime de fogo médio", "/com.daniel.Images/Inimigos/Slime Fireii.png", 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao);
    }
}
