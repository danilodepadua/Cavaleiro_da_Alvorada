package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeEscuridaoNv3 extends Inimigo {
    public InimigoSlimeDeEscuridaoNv3() {
        super("Slime de escuridão grande", "/com.daniel.Images/Inimigos/Slime Darkiii.png", 25, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao);
    }
}
