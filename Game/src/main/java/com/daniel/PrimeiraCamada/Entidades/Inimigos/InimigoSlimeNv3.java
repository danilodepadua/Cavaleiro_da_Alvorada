package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeNv3 extends Inimigo {
    public InimigoSlimeNv3() {
        super("Slime grande", "/com.daniel.Images/Inimigos/slimeiii.png", 4, 25, 20, 20, 30, 25, 25, TiposElementais.Gelo, Comportamentos.padrao, 100, 5);
    }
}
