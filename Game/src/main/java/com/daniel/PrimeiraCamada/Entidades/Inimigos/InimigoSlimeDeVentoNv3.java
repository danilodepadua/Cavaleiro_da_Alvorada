package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeVentoNv3 extends Inimigo {
    public InimigoSlimeDeVentoNv3() {
        super("Slime de vento grande", "/com.daniel.Images/Inimigos/Slime Windiii.png", 19, 45, 35, 35, 60, 45, 45, TiposElementais.Vento, Comportamentos.padrao, 100, 5);
    }
}
