package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeEscuridaoNv1 extends Inimigo {
    public InimigoSlimeDeEscuridaoNv1() {
        super("Slime de escuridão pequeno", "/com.daniel.Images/Inimigos/Slime Darki.png", 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao);
    }
}
