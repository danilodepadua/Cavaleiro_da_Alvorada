package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoCorvoGigante extends Inimigo {
    public InimigoCorvoGigante() {
        super("Corvo gigante", "/com.daniel.Images/Inimigos/Colossal Dark Crow.png", 31, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100);
    }
}
