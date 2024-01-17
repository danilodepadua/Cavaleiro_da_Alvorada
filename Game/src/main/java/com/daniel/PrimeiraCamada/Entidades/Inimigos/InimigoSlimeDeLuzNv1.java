package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeLuzNv1 extends Inimigo {
    public InimigoSlimeDeLuzNv1() {
        super("Slime de luz pequeno", "/com.daniel.Images/Inimigos/Slime Holyi.png", 26, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100);
    }
}
