package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeNv1 extends Inimigo {
    public InimigoSlimeNv1() {
        super("Slime pequeno", "/com.daniel.Images/Inimigos/slimei.png", 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao);
    }
}
