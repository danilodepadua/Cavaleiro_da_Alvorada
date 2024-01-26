package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeRei extends Inimigo {
    public InimigoSlimeRei() {
        super("Rei dos slimes", "/com.daniel.Images/Inimigos/Slime RPG King.png", 35, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100, 5);
    }
}
