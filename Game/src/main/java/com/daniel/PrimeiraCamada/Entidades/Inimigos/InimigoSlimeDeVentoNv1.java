package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeVentoNv1 extends Inimigo {
    public InimigoSlimeDeVentoNv1() {
        super("Slime de vento pequeno", "/com.daniel.Images/Inimigos/Slime Windi.png", 17, 20, 15, 15, 45, 25, 25, TiposElementais.Vento, Comportamentos.padrao, 100, 5);
    }
}
