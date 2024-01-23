package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeLuzNv2 extends Inimigo {
    public InimigoSlimeDeLuzNv2() {
        super("Slime de luz médio", "/com.daniel.Images/Inimigos/Slime Holyii.png", 27,5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100, 5);
    }
}
