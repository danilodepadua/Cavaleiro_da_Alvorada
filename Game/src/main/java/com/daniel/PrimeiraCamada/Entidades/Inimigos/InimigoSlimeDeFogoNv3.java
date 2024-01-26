package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeFogoNv3 extends Inimigo {
    public InimigoSlimeDeFogoNv3() {
        super("Slime de fogo grande", "/com.daniel.Images/Inimigos/Slime Fireiii.png", 7, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100, 5);
    }
}
