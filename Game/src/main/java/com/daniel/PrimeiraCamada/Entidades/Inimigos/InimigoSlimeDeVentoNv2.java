package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeVentoNv2 extends Inimigo {
    public InimigoSlimeDeVentoNv2() {
        super("Slime de vento médio", "/com.daniel.Images/Inimigos/Slime Windii.png", 18, 35, 25, 25, 50, 35, 35, TiposElementais.Vento, Comportamentos.padrao, 100, 5);
    }
}
