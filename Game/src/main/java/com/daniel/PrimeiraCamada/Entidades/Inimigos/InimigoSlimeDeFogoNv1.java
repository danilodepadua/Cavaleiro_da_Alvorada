package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeFogoNv1 extends Inimigo {
    public InimigoSlimeDeFogoNv1() {
        super("Slime de fogo pequeno", "/com.daniel.Images/Inimigos/Slime Firei.png", 5, 5, 5, 5, 5, 5,
                5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100);
    }
}
